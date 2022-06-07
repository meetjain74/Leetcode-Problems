<h2><a href="https://leetcode.com/problems/peak-index-in-a-mountain-array/">852. Peak Index in a Mountain Array</a></h2><h3>Easy</h3><hr><div><p>Let's call an array <code>arr</code> a <strong>mountain</strong>&nbsp;if the following properties hold:</p>

<ul>
	<li><code>arr.length &gt;= 3</code></li>
	<li>There exists some <code>i</code> with&nbsp;<code>0 &lt; i&nbsp;&lt; arr.length - 1</code>&nbsp;such that:
	<ul>
		<li><code>arr[0] &lt; arr[1] &lt; ... arr[i-1] &lt; arr[i] </code></li>
		<li><code>arr[i] &gt; arr[i+1] &gt; ... &gt; arr[arr.length - 1]</code></li>
	</ul>
	</li>
</ul>

<p>Given an integer array <code>arr</code> that is <strong>guaranteed</strong> to be&nbsp;a mountain, return any&nbsp;<code>i</code>&nbsp;such that&nbsp;<code>arr[0] &lt; arr[1] &lt; ... arr[i - 1] &lt; arr[i] &gt; arr[i + 1] &gt; ... &gt; arr[arr.length - 1]</code>.</p>

<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>

<pre><strong>Input:</strong> arr = [0,1,0]
<strong>Output:</strong> 1
</pre>

<p><strong>Example 2:</strong></p>

<pre><strong>Input:</strong> arr = [0,2,1,0]
<strong>Output:</strong> 1
</pre>

<p><strong>Example 3:</strong></p>

<pre><strong>Input:</strong> arr = [0,10,5,2]
<strong>Output:</strong> 1
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>3 &lt;= arr.length &lt;= 10<sup>4</sup></code></li>
	<li><code>0 &lt;= arr[i] &lt;= 10<sup>6</sup></code></li>
	<li><code>arr</code> is <strong>guaranteed</strong> to be a mountain array.</li>
</ul>

<p>&nbsp;</p>
<strong>Follow up:</strong> Finding the <code>O(n)</code> is straightforward, could you find an <code>O(log(n))</code> solution?</div>