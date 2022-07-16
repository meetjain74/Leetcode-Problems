Given two strings, we need to determine whether the strings are scrambled or not. The condition for being scrambled is to make a complete binary tree and swap their non-leaf nodes. For example, after swapping, the string becomes rgeat.

<p align="center">
  <img src="https://user-images.githubusercontent.com/56895638/179361450-5cddf5dd-3e9b-46c4-aa2d-225ce94075eb.png" width="450" height="300">
</p>

- The red ones are leaf nodes, and the blue ones are non-leaf nodes. It depends on which non-leaf nodes we want to swap, and no of swaps can be equal to or greater than zero.
- What happens when both strings are the same, then also both strings are scrambled.
- We can break it at any kth position, but the tree should be complete i.e. no empty nodes.
- This is MCM type question, as we need to check for every kth position.

## Approach

We will break the strings into two parts i.e from (0, ith) to (ith, n - ith) and check whether they are equal or not
This arise two cases, whether the substring is swapped or not. So we have to check
```
          left part of string1 == left part of string2 along with right part of string1 == right part of string2
                                                             or
   	      left part of string1 == right part of string2 along with right part of string1 == left part of string2
``` 

If any one condition becomes true then the string are scrambled. Checking it recursively as child can also be swapped. Take third example in image below for reference.
If length of two strings are not equal then they are not scrambled.

<p align="center">
  <img src="https://user-images.githubusercontent.com/56895638/179361764-b4fe1283-7aee-4042-a541-d6df25e03150.png" width="450" height="300">
</p>
