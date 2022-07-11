class Solution {
    public int numSquares(int n) {
        // Similar to unbounded knapsack or coin change
        int x = (int)Math.sqrt(n);
        
        // dp[i][j] represents minimum number of squares required to create j
        // using the first i squares
        int dp[][] = new int[x+1][n+1];
        
        // dp[i][0] is 0 as no perfect squares needed to create number 0
        
        // dp[0][j] is not possible as number cannot be created with no perfect squares
        for (int j=1;j<=n;j++) {
            dp[0][j] = Integer.MAX_VALUE-1; // Represent infinity
        }
        
        for (int i=1;i<=x;i++) {
            for (int j=1;j<=n;j++) {
                int curr = i*i;
                if (curr>j) {
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = Math.min(dp[i-1][j],1+dp[i][j-curr]);
                }
            }
        }
        
        return dp[x][n];
    }
}