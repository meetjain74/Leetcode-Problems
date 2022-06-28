## Method 1 : Using Reverse Postorder  

Example:  

![image](https://user-images.githubusercontent.com/56895638/176275567-39a05462-240f-4e85-abfc-bee5f31738f1.png)  

### Approach

The algorithm steps can be stated as:   

- If we observe, we are moving in a reverse postorder way : i.e  right, left, root. 
- We take a reference variable (say prev) to store the previous node( initialized to NULL).
- Whenever we visit a node, we set the right child to the prev and left child to NULL. 
- Next we assign this current node to prev.
- We perform the above two operations on all the nodes in the traversal.

### Dry run

![image](https://user-images.githubusercontent.com/56895638/176275904-d5b91f96-c7a1-435a-bc79-a9596b88d789.png)

![image](https://user-images.githubusercontent.com/56895638/176275948-128f2287-623a-49eb-899b-70c014e8a47d.png)  

![image](https://user-images.githubusercontent.com/56895638/176275978-b42f814a-a309-4dfe-b333-db96ab0f938e.png)  

![image](https://user-images.githubusercontent.com/56895638/176276031-6c43d6da-f41c-4cbd-b309-d761038493b4.png)

### Time Complexity: O(N)

### Space Complexity: O(N) 



## Method 2 : Using Stack

### Approach

The algorithm approach can be stated as:

- Take a stack and push the root node to it.
- Set a while loop till the stack is non-empty.
- In every iteration, take the node at the top of the stack( say cur) and pop the stack.
- If cur has a right child, push it to the stack.
- If cur has a left child, push it to the stack.
- Set the right child of cur to node at stack’s top.
- Set the left child of cur as NULL.

### Dry run

![image](https://user-images.githubusercontent.com/56895638/176276555-810b316e-e2fd-4a5c-8f57-4d6cd067699b.png)

![image](https://user-images.githubusercontent.com/56895638/176276526-c8511d23-8ed7-4f03-97ac-ed7bd5144e22.png)

### Time Complexity: O(N)

### Space Complexity: O(N)


## Method 3 : Using approach similar to Morris traversal 

### Approach

The algorithm can be described as:

- At a node(say cur) if there exists a left child, we will find the rightmost node in the left subtree(say prev).
- We will set prev’s right child to cur’s right child,
- We will then set cur’s right child to it’s left child.
- We will then move cur to the next node by assigning cur it to its right child
- We will stop the execution when cur points to NULL.

### Dry run

Consider for the given example -  

![image](https://user-images.githubusercontent.com/56895638/176277148-bfcb05b9-2808-4235-b050-e57824dc4e77.png)

![image](https://user-images.githubusercontent.com/56895638/176277185-a06cd0ca-09d0-4b0f-b12d-2a6a2fcd4571.png)
 
### Time Complexity: O(N)

### Space Complexity: O(1)
 
