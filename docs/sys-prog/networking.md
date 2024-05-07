# [Networking](sys-prog)

## Network Communication

### What do we mean by network communication?

- Sending messages from one computer to another.
- More precisely: from a process on one computer to a process on a different computer.

### What is needed for network communication?

- **Protocol:** What sorts of messages can we send?
	- How are they expressed?
	- When are they sent and by whom?
- **Addressing:** How do we indicate the participants?

### Layers

*Question:* How do I communicate between two computer?

- One Answer: Connect a wire between them.

> Two or more connected devices are called a "*link*".

#### Adding More Than Two Hosts
- *Hub* - in Ethernet, a device with a certain number of ports (e.g., 4) we run a wire from each host to a port on the hub the hub forwards any messages it receives a message from a different MAC, it ignores the message.
- In Ethernet, every message frame includes a *destination address* every Ethernet device has a unique address (MAC) when a device receives a message for a different MAC, it ignores the message.

> Because hubs simply forward frames, they are very simple... -> Fast and inexpensive.

*But,* forwarding each frame to every participant requires a lot of network resources.

#### Switch
- Similar to a hub, but it associates MACs with port messages are only forwarded to the port associated with the destination.
- Because the switch has to examine messages and keep track of MACs, it is slower and more expensive than a hub.

> Typically, a *link* involves devices controlled by a single organization... \
>> -> Not especially secure \
>> -> Every device can talk to any other device \
>> -> Little privacy

### Ethernet
- Also describes how messages are sent...
	- Large messages are broken down into smaller parts.
	- Each part is made into a "*frame*".
	- The frame also includes the **destination address**.
- How is network time divided?
	- In the event two devices try to send at the same time, both will wait a random amount of time and retransmit.
		- *this works well in practice!*

### Internetworking

Communication between devices on *different* networks.

#### Idea
- Our link contains one or more devices called "*routers*" or "*border routers*"
	- A router connects two networks.

#### Internet Protocol

Commonly known the *IP*.

- Hosts are identified by IP address.
	- In IPv4 - **32-bit integers**
		- Commonly written in "*dotted quad*" (`172.0.0.1`)
	- In IPv6 - **128-bit integers**
		- Commonly written as groups of four *hex digits* separated by colons.
- Messages are divided into **packets**.
	- Each packet indicates its source and destination IP addresses packets are sent separately across the network.
	- Routers receiving a packet will transmit it to a peer hopefully getting it closer to its destination.
- *IP* is a "*best effort*" protocol.
	- Packets may be lost
	- Packets may be received out of order.

#### Routing Table

Each router has a **routing table**.

-> Given an IP address, *which outgoing port* should this packet be sent to?

- To keep the routing table **simple**, addresses are grouped into "*subnets*" typically, addresses with similar prefix are part of the same subnet, and so one entry in the table can handle them all.

> In the *early internet*, there were 3 classes of subnets... *Class A* - Uses 8-bit prefix, *Class B* - uses 16-bit prefix, *Class C* - uses 24-bit prefix.

#### Modern
- Modern IPv4 uses "*classless*" routing where subnet prefixes can be any length.
	- Often indicated with a slash and a number. `208.14.128.0/9` - Indicates a subnet with a *9-bit prefix*.
- Routers have their own protocols to send updated routing information.

### Network Stack

#### Link Layer

- communication between machines on the same network : *Ethernet* communicates in *discrete messages* (frames)

#### Internet Layer
- (IP) Communication between machines on the Internet packet forwarding, *best-effort*

- Messages are broken into individual packets, each sent separately.
- These messages can arrive out of order, or not arrive at all.

> *Size of these packets is  typically 20-65,000 bytes.* -> Packets too large are broken down (*fragmented*) and reassembled at the recipient. (1500 bytes is the typical byte size)

- Endpoints are identified by IP address.
	- Identifies a network interface (usually 1 per machine)

#### Transport Layer
- Two different transport protocols

##### UDP

> **User Datagram Protocol**

- Send individual messages from one service to another endpoints identified by *IP address* and *port number*.
- ***best effort, datagram protocol***
- ***non-connection oriented***

##### TCP

> [**Transmission Control Protocol**](../intro-infotech/iti103#tcp/ip)

- Read and write byte streams sent between two services.
- Endpoints identified by IP address and port number

TCP itself makes sure that bytes are received in order by *dividing* the outgoing byte stream into "*segments*" (Each segment is sent in a single packet).

The TCP packets indicate which connection they are part of using:

- `local host:port`
- `remote host:port`

Using `bind()` - you can associate a socket with a port number on the host, which will allow you to listen on a certain port for incoming packets.

----

## Sockets

*Sockets* are a set of functions used to establish network communication part of POSIX.

### Fundamental Type: The Socket

The socket is basically a *file descriptor* that refers to a network service.

	-> Functions attempt to be **as general as possible**.
		-> Does not assume we are using a particular network.
		-> Does not assume we are working at a particular level.

```C

int socket(int domain, int type, int protocol);
```

- *Domain*: what sort of network will we be using (*AF_INET*)
- *Type*: What sort of socket are we creating.
	- `SOCK_STREAM` - Communication via streams (e.g. TCP)
	- `SOCK_DGRAM` - Communication via datagrams (e.g. UDP)
	- `BLAH_BLAH` - A lot more other ones used by other network types.
- *Protocol*: Used to distinguish between multiple transports of the same type (typically 0)

> On Success, *returns a fd*. \
> On Failure, *returns -1*.

*Note:* This `socket()` type only creates a **abstract** socket, but does not configure it.

```C

int connect(int sockfd, const struct sockaddr *addr, socklen_t addrlen);
```

> For **streaming** sockets, establishing a connection with a service on a remote host.

- `sockfd` - the *file descriptor* opened by the abstract socket type.
- `addr` - the address of the remote service.
- `addrlen` - length of the addr struct.

*Note*: Addresses are usually *network-specific structures*.

- We can cast the pointer to `struct sockaddr *` and provide the size.
	- Usually, we don't create this struct ourselves.

`write()` - send data to remote host

`read()` - receive data from remote host.

`close()` - closes both sides of the connection.

`shutdown()` - Used to close one side of the connection.
### DNS

> *Domain Name Service*

The DNS is a *hierarchical database* that stores information about "domains".

- Domains are identified by words separated by periods:
	- `rutgers.edu`
	- `google.com`
	- `amazon.com`
- Each subdomain add additional words to the front of the name.

> Domains are controlled by some organization, which can establish subdomains with their own owners.

#### Domain Protocols

`A` - Associates an IPv4 address with this domain.

`AAAA` - Associates an IPv6 address with this domain.

`MX` - Indicates the machine used for mail handling.

> For many protocols, we look up the IP address of the domain and use that to connect (or send datagrams)

#### Data Storage

- Data is stored *Hierarchically*, similar to directories in the file system.
	- `edu` says where to find `rutgers.edu`
	- `rutgers.edu` says where to find `cs.rutgers.edu`
	- `cs.rutgers.edu` says where to find `wax.cs.rutgers.edu`...
	- and so on...

> Typically, you have a *local DNS server* that caches the results from past DNS queries.

The Unix commands `host` and `dig` perform DNS queries and print the results.

Typically, your local internet configuration will specify a DNS server used for queries.

#### Using DNS to Get Addresses

##### The Old Way

`gethostbyname()` -> old, no bueno.

##### The Better Way

```C

int getaddrinfo(
	const char *node,        // e.g. domain name
	const char *service,     // e.g. service name or port #
	const struct addrinfo *hints,   // used to narrow down results
	struct addrinfo **res   // Will point to first entry of a linked list of answers
);
```

> On success, *returns 0*. On *failure*, returns an error code.

This error code is not compatible with `errno` or `perror()`, etc...

- Use `gai_strerror()` to get a description of the error.

```C

struct addrinfo {
	int ai_flags;
	int ai_family;              // domain argument to socket()
	int ai_socktype;            // type argument to socket()
	int ai_protocol;            // protocol argument to socket()
	socklen_t ai_addrlen;       
	struct sockaddr *ai_addr;   // addr argument to connect()
	char *ai_cannonname;
	struct addrinfo *ai_next;
};
```

> See `network.c` for examples of using `getaddrinfo()` with `socket()` and `connect()`.

##### Usual Pattern for Clients
- Use `getaddrinfo()` to get a linked list of address information records...
- Use these with `socket()` and `connect()` to establish connection.

###### Client server Pattern
- Client creates connections (Active)
- server waits for clients to request connections (Passive)

> Establishing a *listening socket* requires three functions...

```C

int bind(int sockfd, const struct sockaddr *addr, socklen_t addrlen);
```

- Tells the network system to associate our socket with a specific port on the local host.
- `sockfd` - fd obtained from `socket()`.
- `addr` - idnetifies the port (recommended: *Obtain from `getaddrinfo`*).

> Returns 0 on success, returns -1 on failure and sets `errno`

```C

int listen(int sockfd, int backlog);
```

- Tells the network system that we want to wait for incoming connection requests.
- `sockfd` - Obtained from `socket()`
- `backlog` - determines size of connection request queue.

> Returns 0 on succes, -1 on failure (sets `errno`)

```C

int accept(int sockfd, struct sockaddr *addr, socklen_t *addrlen);
```

- Obtains file descriptor for incoming connection request (block until one arrives, if none have arrived yet)
- `sockfd` - listening socket
- `addr` - address of remote host will be written here.
	- (*Use `NULL` if we don't care*)

> Returns new streaming socket specific to this connection, returns -1 on failure and sets `errno`

*Note:* Each time we accept a connection request, we get a new socket.

## Server Structure

> "One at a time"

- Repeating forever:
	- Accept incoming connection
	- Communicate with peer
	- Close connection
- Easy to write
- Can only deal with one client at a time...

> "One per process"

- Repeating forever:
	- Accept incoming connection
	- Fork child process
		- In child: deal with connection.
	- Wait for child to terminate, then close connection.

- Using this process, it allows *multiple* concurrent connections.
- Provides some insulation (one connection handler cannot crash server)
- Cumbersome communication between parent and children.

**Problem:** How to deal with zombies???

- Install handlers for `SIGCHILD`
	- Handler uses `waitpid()` to clean up specific zombies.
- Set `SIGCHILD` to `SIG_IGN`
	- Prevents child processes from becoming zombies. (they just disappear when they die)

> One connection per thread

- Repeating forever:
	- Accept incoming connection.
	- Create new thread to handle connection.
	- Detach thread


**Perks and Drawbacks:**

- This allows multiple concurrent connections.
- Easily share data among all connection handler threads.
- Minimal protection from infinite loops or crashes.

*We might want to address signal handling...*

- Signals sent to a multithreaded program will be handled by an undetermined thread.
	- We can control this by setting signal masks per thread.
	- e.g. `SIGINT` or `SIGHUP` being handled by primary thread.
**
### Multiplexing

- Fewer threads than connections.
- **Problem:** We don't know what events will happen next.
	- Should we call `accept()` or `read()` on a particular socket?
	- How do we avoid waiting unnecessarily?
- **Solution:** `select()` or `poll()` allow us to block on multiple file descriptors at once and wait until any of them are ready.
- Lower latency than using multiple threads.
- More complicated to write.
- Makes it easy to specify timeouts.
