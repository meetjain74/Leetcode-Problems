# Minimum steps to make product equal to one
## Easy 
<div class="problem-statement">
                <p></p><p><span style="font-size:18px">Given an array <strong>arr[]</strong> containing <strong>N</strong> integers. In one step, any element of the array can either be increased or decreased by one. Find minimum steps required such that the product of the array elements becomes <strong>1</strong>. </span></p>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:
</strong>N = 3
arr[] = {-2, 4, 0}
<strong>Output:
</strong>5
<strong>Explanation:</strong>
We can change -2 to -1, 0 to -1 and 4 to 1.
So, a total of 5 steps are required
to update the elements such that
the product of the final array is 1.</span> 
</pre>

<div><span style="font-size:18px"><strong>Example 2:</strong></span></div>

<pre><span style="font-size:18px"><strong>Input:
</strong>N = 3
arr[] = {-1, 1, -1} 
<strong>Output :</strong>
0</span>
<span style="font-size:18px"><strong>Explanation:</strong>
Product of the array is already 1.
So, we don't need to change anything.</span>
</pre>

<p><br>
<span style="font-size:18px"><strong>Your Task:&nbsp;&nbsp;</strong><br>
You don't need to read input or print anything. Your task is to complete the function <strong>makeProductOne()</strong>&nbsp;which takes an integer N and an array arr of size N as input and returns the minimum steps required.</span></p>

<p><br>
<span style="font-size:18px"><strong>Expected Time Complexity:</strong> O(N)<br>
<strong>Expected Auxiliary Space:</strong> O(1)</span></p>

<p><br>
<span style="font-size:18px"><strong>Constraints:</strong><br>
1 ≤ N ≤ 10<sup>5</sup><br>
-10<sup>3</sup> ≤ arr[i] ≤ 10<sup>3</sup></span></p>
 <p></p>
            </div>