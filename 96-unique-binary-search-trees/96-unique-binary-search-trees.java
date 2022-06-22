class Solution {
    public int numTrees(int n) {
        
        // dp[i] represents the number of unique binary search trees consisting of i nodes
        int dp[] = new int[n+1];
        
        dp[0]=1;
        dp[1]=1;
        
        for (int i=2;i<=n;i++) {
            // Determining no of unique bst for tree with i nodes
            // Consider each number as root once from 1 to i 
            for (int j=1;j<=i;j++) {
                // If j is root
                // Left subtree can only contain nodes with value less than j i.e (j-1) nodes
                // Right subtree can only contain nodes with value more than j i.e (i-j) nodes
                dp[i] = dp[i] + dp[j-1] * dp[i-j];
            }
        }
        
        return dp[n];
    }
}