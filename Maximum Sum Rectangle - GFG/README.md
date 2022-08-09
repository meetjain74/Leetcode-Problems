# [Maximum sum rectangle](https://practice.geeksforgeeks.org/problems/maximum-sum-rectangle2948/1)
## Medium 
<div class="problem-statement">
                <p></p><p><span style="font-size:18px">Given a 2D matrix M of dimensions RxC. Find the maximum sum submatrix in it.</span></p>

<p><strong><span style="font-size:18px">Example 1:</span></strong></p>

<pre><strong><span style="font-size:18px">Input:
</span></strong><span style="font-size:18px">R=4
C=5
M=[[1,2,-1,-4,-20],
[-8,-3,4,2,1],
[3,8,10,1,3],
[-4,-1,1,7,-6]]
<strong>Output: </strong>29
<strong>Explanation</strong>
The matrix is as follows and the
blue rectangle denotes the maximum sum
rectangle.
</span>
</pre>
![image](https://user-images.githubusercontent.com/56895638/183567138-4abf7aa5-4481-476c-b267-c23b2a773b81.png)
  

<p><strong><span style="font-size:18px">Example 2:</span></strong></p>

<pre><strong><span style="font-size:18px">Input:
</span></strong><span style="font-size:18px">R=2
C=2
M=[[-1,-2],[-3,-4]]
<strong>Output: </strong>-1
<strong>Explanation</strong>
Taking only the first cell is the 
optimal choice.
</span>
</pre>
 
<p><span style="font-size:18px"><strong>Your Task:</strong><br>
You don't need to read input or print anything. Your task is to complete the function <strong>maximumSumRectangle()</strong> which takes the number R, C, and the 2D matrix M as input parameters and returns the maximum sum submatrix.
<p><span style="font-size:18px"><strong>Expected Time Complexity:</strong>&nbsp;O(R*R*C).<br>
<strong>Expected Auxiliary Space:</strong>&nbsp;O(R)</span></p>

<p><span style="font-size:18px"><strong>Constraints:</strong></span><br>
<span style="font-size:18px">1 ≤ R,C ≤ 500</span><br>
<span style="font-size:18px">-1000 ≤ M[i][j] ≤ 1000</span><br>
 <p></p>
            </div>
