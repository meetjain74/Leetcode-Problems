# Mobile numeric keypad
## Medium 
<div class="problem-statement">
                <p></p><p><span style="font-size:18px">Given the mobile numeric keypad. You can only press buttons that are up, left, right, or down to the current button. You are not allowed to press bottom row corner buttons (i.e. * and # ). Given a number <strong>N</strong>, the task is to find out the number of possible numbers of the given length.</span></p>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input</strong>: 1
<strong>Output:</strong> 10
<strong>Explanation</strong>: Number of possible numbers 
would be 10 (0, 1, 2, 3, …., 9)  </span></pre>

<div><span style="font-size:18px"><strong>Example 2:</strong></span></div>

<pre><span style="font-size:18px"><strong>Input: </strong>N = 2
<strong>Output: </strong>36
<strong>Explanation</strong>: Possible numbers: 00, 08, 11,
12, 14, 22, 21, 23, 25 and so on.
If we start with 0, valid numbers 
will be 00, 08 (count: 2)
If we start with 1, valid numbers 
will be 11, 12, 14 (count: 3)
If we start with 2, valid numbers 
will be 22, 21, 23,25 (count: 4)
If we start with 3, valid numbers 
will be 33, 32, 36 (count: 3)
If we start with 4, valid numbers 
will be 44,41,45,47 (count: 4)
If we start with 5, valid numbers 
will be 55,54,52,56,58 (count: 5) 
and so on..</span></pre>

<p><br>
<span style="font-size:18px"><strong>Your Task:&nbsp;&nbsp;</strong><br>
You don't need to read input or print anything. Complete the function <strong><code>getCount</code>()&nbsp;</strong>which takes <strong>N</strong> as input parameter and returns the integer value<br>
<br>
<strong>Expected Time Complexity:</strong> O(<strong>N</strong>)<br>
<strong>Expected Auxiliary Space:</strong> O(<strong>N</strong>)<br>
<br>
<strong>Constraints:</strong><br>
1 ≤&nbsp;<strong>N</strong> ≤ 25</span></p>
 <p></p>
            </div>