class Solution {
    public int change(int amount, int[] coins) {
        // Similar to unbounded knapsack
        // Count no of subsets which sum to target
        
        int n = coins.length;
        
        // dp[i][j] represents number of ways to make j amount
        // using the first i coins
        int dp[][] = new int[n+1][amount+1];
        
        // dp[i][0] is 1 as no coins required to make 0 amount and this is one way
        for (int i=0;i<=n;i++) {
            dp[i][0]=1;
        }
        
        // dp[0][j] is 0 as no ways possible to create j amount with no coins
        
        for (int i=1;i<=n;i++) {
            for (int j=1;j<=amount;j++) {
                int currCoin = coins[i-1];
                
                if (currCoin>j) {
                    // Ignore this coin
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    // This coin may be taken
                    // Take both cases - Ignore coin and take that coin
                    dp[i][j] = dp[i-1][j] + dp[i][j-currCoin];
                }
            }
        }
        
        return dp[n][amount];
    }
}