# Smallest number on left
## Medium 
<div class="problem-statement">
                <p></p><p><span style="font-size:20px">Given an array <strong>a&nbsp;</strong>of integers of length <strong>n</strong>, find the nearest smaller number for every element such that the smaller element is on left side.If no small element present on the left print -1.</span></p>

<p><strong><span style="font-size:20px">Example 1:</span></strong></p>

<pre><span style="font-size:20px"><strong>Input:</strong> n = 3
a = {1, 6, 2}
<strong>Output:</strong> -1 1 1
<strong>Explaination:</strong> There is no number at the 
left of 1. Smaller number than 6 and 2 is 1.</span></pre>

<p><strong><span style="font-size:20px">Example 2:</span></strong></p>

<pre><span style="font-size:20px"><strong>Input:</strong> n = 6
a = {1, 5, 0, 3, 4, 5}
<strong>Output:</strong> -1 1 -1 0 3 4
<strong>Explaination:</strong> Upto 3 it is easy to see 
the smaller numbers. But for 4 the smaller 
numbers are 1, 0 and 3. But among them 3 
is closest. Similary for 5 it is 4.</span></pre>

<p><span style="font-size:20px"><strong>Your Task:</strong><br>
You do not need to read input or print anything. Your task is to complete the function <strong>leftSmaller()</strong> which takes n and a as input parameters and returns the list of smaller numbers.</span></p>

<p><span style="font-size:20px"><strong>Expected Time Complexity:</strong> O(n)<br>
<strong>Expected Auxiliary Space:</strong> O(n)</span></p>

<p><span style="font-size:20px"><strong>Constraints:</strong><br>
1 ≤ n ≤ 100<br>
1 ≤ a[i] ≤ 10<sup>4</sup>&nbsp;&nbsp;</span></p>
 <p></p>
            </div>