### Midterm 2 Review

1.

```java

CLLNode prev = null;

if(rear.next.data == item) prev = rear;
CLLNode ptr = rear;
while(ptr.next != rear) {
	if(ptr.next.data == item) prev = ptr;
	ptr= ptr.next;
	}

if(ptr.next == rear) {
	ptr.next = ptr.next.next;
	rear = ptr;
} else {
	ptr.next = ptr.next.next;
	}

```

2.

```java

public Node successor(Node h) {
	if(h == null || h.right == null) return null;
	Node ptr = h.right;

	while(ptr.left != null) {
		ptr = ptr.left;
		}
	}

```

3.

Look on your phone.

d) A

4.

a) No it is not because the parents are not greater than or equal to all of the child branches.

5.

a) 

| 0 |      |      |      |
|---|------|------|------|
| 1 | 4371 |
| 2 |
| 3 | 1323 | 6173 |
| 4 | 4344 |
| 5 |
| 7 |
| 8 |
| 9 | 1989 | 9679 | 4199 |

b)

| 0    | 1    | 2    | 3    | 4    | 5    | 6 | 7 | 8 | 9    |
|------|------|------|------|------|------|---|---|---|------|
| 9579 | 4371 | 1989 | 1323 | 6173 | 4344 |   |   |   | 4199 |
