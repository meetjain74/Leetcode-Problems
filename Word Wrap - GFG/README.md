# [Word Wrap](https://practice.geeksforgeeks.org/problems/word-wrap1646/1)
## Hard 
<div class="problem-statement">
  <p></p><p><span style="font-size:18px">Given an array <strong>nums[]</strong> of size <strong>n</strong>, where <strong>nums[i]</strong> denotes the number of characters in one word. Let <strong>K</strong> be the limit on the number of characters that can be put in one line (line width). 
  Put line breaks in the given sequence such that the lines are printed neatly.   
Assume that the length of each word is smaller than the line width. When line breaks are inserted there is a possibility that extra spaces are present in each line. 
  The extra spaces include spaces put at the end of every line <strong>except the last one</strong>. 

You have to <strong>minimize</strong> the following total cost where <strong>total cost</strong> = Sum of cost of all lines, where cost of line is = (Number of extra spaces in the line)<sup>2</sup>.
  </span><br>
&nbsp;</p>

<p><strong><span style="font-size:18px">Example 1:</span></strong></p>

<pre><span style="font-size:18px"><strong>Input: </strong>nums = {3,2,2,5}, k = 6
<strong>Output:</strong> 10
<strong>Explanation: </strong>Given a line can have 6
characters,
Line number 1: From word no. 1 to 1
Line number 2: From word no. 2 to 3
Line number 3: From word no. 4 to 4
So total cost = (6-3)<sup>2</sup> + (6-2-2-1)<sup>2</sup> = 3<sup>2</sup>+1<sup>2</sup> = 10.
As in the first line word length = 3 thus
extra spaces = 6 - 3 = 3 and in the second line
there are two word of length 2 and there already
1 space between two word thus extra spaces
= 6 - 2 -2 -1 = 1. As mentioned in the problem
description there will be no extra spaces in
the last line. Placing first and second word
in first line and third word on second line
would take a cost of 0<sup>2</sup> + 4<sup>2</sup> = 16 (zero spaces
on first line and 6-2 = 4 spaces on second),
which isn't the minimum possible cost.</span></pre>

<p><br>
<span style="font-size:18px"><strong>Example 2:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input: </strong>nums = {3,2,2}, k = 4
<strong>Output:</strong> 5
<strong>Explanation: </strong>Given a line can have 4 
characters,
Line number 1: From word no. 1 to 1
Line number 2: From word no. 2 to 2
Line number 3: From word no. 3 to 3
Same explaination as above total cost
= (4 - 3)<sup>2</sup> + (4 - 2)<sup>2</sup> = 5.</span></pre>

<p><br>
<span style="font-size:18px"><strong>Your Task:</strong><br>
You don't need to read or print anyhting. Your task is to complete the function <strong>solveWordWrap()</strong> which takes nums and k as input paramater and returns the minimized total cost.
  </span></p>

<p><br>
<span style="font-size:18px"><strong>Expected Time Complexity:</strong> O(n<sup>2</sup>)<br>
<strong>Expected Auxiliary Space:</strong> O(n)</span></p>

<p><br>
<span style="font-size:18px"><strong>Constraints:</strong><br>
1 &lt;= n &lt;= 500<br>
1 &lt;= nums[i] &lt;= 1000<br>
max(nums[i]) &lt;= k &lt;= 2000</span></p>
 <p></p>
            </div>
