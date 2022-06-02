class Solution {
    public int maxProfit(int k, int[] prices) {
        int days = prices.length;
        if (days==0) 
            return 0;
        
        int dp[][] = new int[k+1][days];
        // Dp array with k+1 rows and days columns
        // dp[i][j] represents maximum profit of i transactions upto j days
        
        // dp[0][j] will be 0 as profit of 0 transactions is 0
        // dp[i][0] will be 0 as profit upto first day is 0
        
        for (int i=1;i<=k;i++) {
            for (int j=1;j<days;j++) {
                // dp[i][day] will be maximum of dp[i][day-1] and
                // dp[i-1][j]+new tx i.e max profit upto transaction i-1 and j<day
                
                int max = dp[i][j-1];
                
                for (int past=0;past<j;past++) {
                    int profitTillOneLessTransaction = dp[i-1][past];
                    int finalTransaction = prices[j]-prices[past];
                    
                    max = Math.max(max,
                                   profitTillOneLessTransaction+finalTransaction);
                }
                
                dp[i][j] = max;
            }
        }
        
        return dp[k][days-1];
    }
}
