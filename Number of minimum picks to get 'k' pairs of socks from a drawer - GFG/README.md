# Number of minimum picks to get 'k' pairs of socks from a drawer
## Medium 
<div class="problem-statement">
                <p></p><p><span style="font-size:18px">A drawer contains socks of <strong>n</strong>&nbsp;different colours. The number of socks available of i<sup>th</sup>&nbsp;colour is given by <strong>a[i]</strong> where <strong>a</strong>&nbsp;is an array of <strong>n</strong> elements. Tony wants to take <strong>k</strong>&nbsp;pairs of socks out of the drawer. However, he&nbsp;cannot see the colour of the sock that he is picking. You have to tell what is the minimum number of socks Tony has to pick in one attempt from the drawer such that&nbsp;he can be absolutely sure, without seeing their colours,&nbsp;that he will have at least k matching pairs.</span></p>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:
</strong>N = 4, K = 6
a[] = {3, 4, 5, 3}</span>
<span style="font-size:18px"><strong>Output:</strong> 15</span>
<span style="font-size:18px"><strong>Explanation:</strong> 
All 15 socks have to be picked in order
to obtain 6 pairs.</span></pre>

<p><span style="font-size:18px"><strong>Example 2:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input: </strong>N = 2, K = 3
a[] = {4, 6}</span>
<span style="font-size:18px"><strong>Output:</strong> 7</span>
<span style="font-size:18px"><strong>Explanation:</strong> The Worst case scenario after 6
picks can be {3,3} or {1,5} of each
coloured socks. Hence 7th pick will ensure
3rd pair. </span></pre>

<p><span style="font-size:18px"><strong>Your Task: </strong>&nbsp;<br>
You don't need to read input or print anything. Complete the function <strong>find_min()</strong> which takes the array a[], size of array N, and value K as input parameters and returns the minimum number of&nbsp;socks Tony has to pick. If it is not possible to pick then return&nbsp;-1. </span></p>

<p><span style="font-size:18px"><strong>Expected Time Complexity:</strong> O(N)<br>
<strong>Expected Auxiliary Space:</strong> O(1)</span></p>

<p><span style="font-size:18px"><strong>Constraints:</strong><br>
1 ≤ N ≤ 10<sup>5</sup>&nbsp;<br>
1 ≤ a[i] ≤ 10<sup>6</sup></span></p>
 <p></p>
            </div>