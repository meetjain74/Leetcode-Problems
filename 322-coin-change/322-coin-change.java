class Solution {
    public int coinChange(int[] coins, int amount) {
        // Similar to unbounded knapsack
        int n = coins.length;
        
        // dp[i][j] represents minimum number of coins required
        // for amount j using first i coins
        int dp[][] = new int[n+1][amount+1];
        
        // dp[i][0] is 0 as no coins required to create amount 0
        
        // dp[0][j] is not possible as any amount cannot be created using no coins
        for (int j=0;j<=amount;j++) {
            dp[0][j] = Integer.MAX_VALUE-1; // Represent infinity
        }
        
        for (int i=1;i<=n;i++) {
            for (int j=1;j<=amount;j++) {
                
                int currCoin = coins[i-1];
                if (currCoin>j) {
                    // Ignore this coin
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    // This coin may be taken
                    dp[i][j] = Math.min(dp[i-1][j],1+dp[i][j-currCoin]);
                }
            }
        }
        
        return dp[n][amount]==Integer.MAX_VALUE-1 ? -1 : dp[n][amount];
    }
}