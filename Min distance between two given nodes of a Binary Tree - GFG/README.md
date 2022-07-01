# Min distance between two given nodes of a Binary Tree
## Medium 
<div class="problem-statement">
                <p></p><p><span style="font-size:18px">Given a&nbsp;binary tree&nbsp;and two node&nbsp;values your task is to find the minimum distance between them.</span></p>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:
&nbsp;       </strong>1
&nbsp;     /  \
&nbsp;    2    3
a = 2, b = 3<strong>
</strong><strong>Output: </strong>2<strong>
Explanation: </strong>The tree formed is:
&nbsp; &nbsp; &nbsp;  1
&nbsp; &nbsp; &nbsp;/&nbsp; &nbsp;\&nbsp;
&nbsp;  &nbsp;2&nbsp; &nbsp; &nbsp;3
We need the distance between 2 and 3.
Being at node 2, we need to take two
steps ahead in order to reach node 3.
The path followed will be:
2 -&gt; 1 -&gt; 3. Hence, the result is 2.&nbsp;</span></pre>

<p dir="ltr"><span style="font-size:18px"><strong>Your Task:</strong><br>
You don't need to read input or print anything. Your task is to complete the function&nbsp;<strong>findDist()&nbsp;</strong>which takes the <strong>root </strong>node of the Tree and the two node values <strong>a</strong> and <strong>b</strong>&nbsp;as input parameters&nbsp;and returns the minimum distance between the nodes represented by the two given node values.<br>
<strong>Note:</strong>The <strong>Input/Ouput</strong> format and <strong>Example</strong> given are used for system's internal purpose, and should be used by a user for <strong>Expected Output</strong> only. As it is a function problem, hence a user should not read any input from stdin/console. The task is to complete the function specified, and not to write the full code.</span></p>

<p dir="ltr"><span style="font-size:18px"><strong>Expected Time Complexity:&nbsp;</strong>O(N).<br>
<strong>Expected Auxiliary Space:&nbsp;</strong>O(Height of the Tree).</span></p>

<p dir="ltr"><span style="font-size:18px"><strong>Constraints:</strong><br>
1 &lt;= Number of nodes &lt;= 10<sup>4</sup><br>
1 &lt;= Data of a node &lt;= 10<sup>5</sup></span></p>
 <p></p>
            </div>