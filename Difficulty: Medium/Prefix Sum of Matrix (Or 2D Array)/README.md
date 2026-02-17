<h2><a href="https://www.geeksforgeeks.org/problems/prefix-sum-of-matrix-or-2d-array/1">Prefix Sum of Matrix (Or 2D Array)</a></h2><h3>Difficulty Level : Difficulty: Medium</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size: 18px;">Given a integer matrix (or 2D array) <strong>a[][]</strong> of dimensions <strong>n *&nbsp;m</strong>. Also, given another 2-D array&nbsp;<strong>query[][]</strong> of dimensions <strong>q *&nbsp;4</strong>. </span></p>
<p><span style="font-size: 18px;">For each index 0 &lt; i &lt; query.length, find the sum of all the elements of the rectangular matrix whose top left corner is (query[i][0], query[i][1]) and bottom right corner is (query[i][2], query[i][3]).</span></p>
<p><span style="font-size: 18px;">Example -&nbsp;</span></p>
<pre><span style="font-size: 18px;"><strong>Input:</strong>
n = 3, m = 3, q = 2 
a[][] = [
          [ 1, 2, 3],
          [ 4, 5, 6],
          [ 7, 8, 9]
        ]</span>

<span style="font-size: 18px;">query[][] = [
               [0, 0, 2, 2]
               [1, 0, 2, 1]
            ]</span>

<span style="font-size: 18px;"><strong>Output:</strong>
45
24</span>

<strong><span style="font-size: 18px;">Explanation:</span></strong>

<span style="font-size: 18px;">The sum of all the elements in the matrix whose top left corner is (0, 0) and the bottom right corner is (2, 2) is 45.</span>

<span style="font-size: 18px;">The sum of all the elements in the matrix whose top left corner is (1, 0) and the bottom right corner is (2, 1) is 24.</span></pre>
<p><br><span style="font-size: 18px;"><strong>Your Task:</strong></span></p>
<p><span style="font-size: 18px;">You&nbsp;don't&nbsp;have to print anything, printing is done by the driver code itself. Your task is to complete the function submatrixSum()&nbsp;which takes the array <strong>a[][]</strong>,&nbsp;its dimensions&nbsp;<strong>n, m</strong>,&nbsp; the <strong>query[][]</strong> array, and its dimension <strong>q</strong> as the inputs and returns the vector/list of where the i<sup>th</sup>&nbsp;element denotes answer of i<sup>th</sup>&nbsp;query.</span></p>
<p><span style="font-size: 18px;">Expected Time Complexity: <strong>O(n<sup>2 </sup>+ q)</strong><br>Expected Space Complexity: <strong>O(n<sup>2</sup>)&nbsp;</strong></span></p>
<p><br><span style="font-size: 18px;"><strong>Constraints:</strong><br>0 &lt; n, m &lt; 10<sup>3</sup></span></p>
<p><span style="font-size: 18px;">0 &lt; n * m &lt; 10<sup>6</sup></span></p>
<p><span style="font-size: 18px;">0 &lt; q &lt; 10<sup>3</sup></span></p>
<p><span style="font-size: 18px;">0 &lt; a[i][j] &lt; 10<sup>9</sup></span></p>
<p><span style="font-size: 18px;">0 &lt; query[i][0], query[i][2] &lt; n</span></p>
<p><span style="font-size: 18px;">0 &lt; query[i][1], query[i][3] &lt; m</span></p></div><br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Arrays</code>&nbsp;<code>Matrix</code>&nbsp;<code>Data Structures</code>&nbsp;