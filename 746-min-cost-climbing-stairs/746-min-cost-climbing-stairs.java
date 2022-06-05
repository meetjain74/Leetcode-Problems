class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        
        // dp[i] represents min cost from step i to reach top of the floor 
        int dp[] = new int[n+1];
        dp[n] = 0;
        
        for (int i=n-1;i>=0;i--) {
            if (i==n-1)
                dp[i] = cost[i]+dp[i+1];
            else
                dp[i] = cost[i]+Math.min(dp[i+1],dp[i+2]);
        }

        return Math.min(dp[0],dp[1]);
    }
}