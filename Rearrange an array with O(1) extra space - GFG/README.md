# Rearrange an array with O(1) extra space
## Medium 
<div class="problem-statement">
                <p></p><p><span style="font-size:18px">Given an array&nbsp;<strong>arr[]</strong>&nbsp;of size <strong>N</strong> where every element is in the range from&nbsp;<strong>0&nbsp;to&nbsp;n-1</strong>. Rearrange the given array so that&nbsp;<strong>arr[i]&nbsp;</strong>becomes&nbsp;<strong>arr[arr[i]]</strong>.</span></p>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:
</strong>N = 2
arr[] = {1,0}
<strong>Output: </strong>0 1<strong>
Explanation: 
</strong>arr[arr[0]] = arr[1] = 0.
arr[arr[1]] = arr[0] = 1.</span>
</pre>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Example 2:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:
</strong>N = 5
arr[] = {4,0,2,1,3}
<strong>Output: </strong>3 4 2 0 1<strong>
Explanation: 
</strong>arr[arr[0]] = arr[4] = 3.
arr[arr[1]] = arr[0] = 4.
and so on.
</span></pre>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Your Task:</strong><br>
You don't need to read input or print anything.&nbsp;The task is to complete the function <strong>arrange</strong>() which takes arr and N as input parameters and rearranges the elements in the array in-place.<strong>&nbsp;</strong></span></p>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Expected Time Complexity:&nbsp;</strong>O(N)<br>
<strong>Expected Auxiliary Space:&nbsp;</strong>O(1)</span></p>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Constraints:</strong></span><br>
<span style="font-size:18px">1 &lt;= N &lt;= 10<sup>7</sup><br>
0 &lt;= Arr[i] &lt; N</span></p>
 <p></p>
            </div>