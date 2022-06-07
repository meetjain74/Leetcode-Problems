<h2><a href="https://leetcode.com/problems/counting-bits/">338. Counting Bits</a></h2><h3>Easy</h3><hr><div><p>
  Given an integer <code>n</code>, return <em>an array <code>ans</code> of length <code>n + 1</code> such that for each <code>i</code> (<code>0 <= i <= n</code>), <code>ans[i]</code> is <strong>the number of</strong> <code>1</code>'s in the binary representation of <code>i</code>.
</em></p>

<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>

<pre><strong>Input:</strong> n = 2
<strong>Output:</strong> [0,1,1]
<strong>Explanation:</strong>
0 --> 0
1 --> 1
2 --> 10
</pre>

<p><strong>Example 2:</strong></p>

<pre><strong>Input:</strong> n = 5
<strong>Output:</strong> [0,1,1,2,1,2]
<strong>Explanation:</strong>
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= n &lt;= 10<sup>5</sup></code></li>
</ul>

<p>&nbsp;</p>
<strong>Follow-up:&nbsp;</strong>
<ul>
  <li>It is very easy to come up with a solution with a runtime of <code>O(n log n)</code>. Can you do it in linear time <code>O(n)</code> and possibly in a single pass?</li>
  <li>Can you do it without using any built-in function (i.e., like <code>__builtin_popcount</code> in C++)?</li>
</ul>  
</div>
