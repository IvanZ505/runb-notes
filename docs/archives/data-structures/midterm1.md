### Data Structures S22 Review

Problem 1:

a)

n=10
| when i is | j will run | runs n times |
| --------- | ---------- | ------------ |
| 0         | 9          | n-1          |
| 1         | 8          | n-2          |
| 2         | 7          | n-3          |

ITS A GODDAMN TRIANGLE DAWG!!!!

The loop is run (n-1)*n/2 times. The outside for is (n-1) times multiplied by the inside for loop which is (n/2) times.

b) Runs inside for loop n/2*(n-1) times with 2 array accesses per time. Giving us n for the inner for loop. The outer for loop runs n-1 times with 4 array accesses per time giving us 4n-4 added to n(n-1) which gives us n^2-3n-4.

c) ~n^2

d) O(n^2)

Problem 2:

a)

| 0   | 1   | 2   | 3   | 4   | 5   | 6   | 7   | 8   | 9   |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| 5   | 5   | 3   | 3   | 4   | 5   | 6   | 5   | 3   | 9   |

b) INCORRECT

| 0   | 1   | 2   | 3   | 4   | 5   | 6   | 7   | 8   | 9   |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| 7   | 5   | 8   | 3   | 4   | 2   | 6   | 1   | 8   | 9   |

correct answer:

| parent | 0   | 1   | 2   | 3   | 4   | 5   | 6   | 7   | 8   | 9   |
| ------ | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| -      | 7   | 5   | 8   | 3   | 4   | 8   | 6   | 5   | 8   | 9   |


c)

Draw out a tree first! Really helps.

| parent | 0   | 1   | 2   | 3   | 4   | 5   | 6   | 7   | 8   | 9   |
| ------ | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| -      | 0   | 0   | 0   | 3   | 4   | 1   | 6   | 0   | 2   | 9   |

| size | 0   | 1   | 2   | 3   | 4   | 5   | 6   | 7   | 8   | 9   |
| ---- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| -    | 6   | 2   | 2   | 1   | 1   | 1   | 1   | 1   | 1   | 1   |



Problem 3:

a)

3 5 4
16
0

b) eueuq dna kcats

c) For 13524 to become possible, you would need the first iteration to be true, printing out 1. Then, you would need the second iteration to return false, to push 2 into the stack. Next, 3 must return true, which it can. Afterwards, 4 must return false and get pushed into the stack. Lastly, 5 would need to be printed out with randomBool returning true. However, you would not be able to get 24 as 2 is further down the stack than 4 is meaning 4 would be printed first.

d) That is possible, following the same logic as before 135 can all be printed out with a true boolean and 42 comes out in the right order.

Problem 4:

a)

for(Node ptr = uniqueColorList; ptr.next != null; ptr = ptr.next) {
	if(ptr.pixel.equals(color)) {
		return true;
		}
}
return false;

b)

Node ptr = uniqueColorList;
uniqueColorList = new Node();
uniqueColorList.pixel = color;
uniqueColorList.next = ptr;

Problem 5:

a) 5

b) (3+3+3+1+2+3+3)/7 = 2.something

WRONG!!!! Beware of the left or right branch!!!

c) O(n) if the tree is extremely scewed, making it need O(n) comparisons needed to find the node to remove.

d) B

WRONG!!! Dont be lazy just draw it out bro...

### Fall 2022 Practice Exam:

Problem 1:

a) 2*rows*cols
b) ~2*rows*cols
c) O(rows*cols)

Problem 2:

a) A for loop using sequential search on the unsorted array  of size A. Inside the for loop, for each of the items in the unsorted array, we will use binary search to look for that item in the sorted array. This would give us a runtime of O(n*logm).

b) O(n*logm)

Problem 3:

| a) Yes | b) Yes | c) No | d) Yes | e) Yes | f) No | g) 4 |
| ------ | ------ | ----- | ------ | ------ | ----- | ---- |

a) add s = copy;

b) The worst case runtime for push would be O(n) and that would be if the array was full.

c) 4

Problem 5:

a) O(1) because inserting a node only requires making a new node linked to the element after the reference to the end of the list and then relinking the reference to that new node.

b) O(n) if the algorithm traverses the entire linked list before finding the item. Ex: if it goes left first, and the item you want to insert is the largest in the linked list.
 
