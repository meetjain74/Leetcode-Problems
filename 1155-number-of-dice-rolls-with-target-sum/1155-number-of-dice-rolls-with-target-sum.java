class Solution {
    int mod = (int)1e9+7;
    public int numRollsToTarget(int n, int k, int target) {
        int dp[][] = new int[n+1][target+1];
        for (int i=0;i<n+1;i++) {
            Arrays.fill(dp[i],-1);
        }
        return solve(n,k,target,dp);
    }
    
    public int solve(int n,int k,int target,int[][] dp) {
        if (target==0 && n==0)
            return 1;
        
        if (target<0 || n==0)
            return 0;
        
        if (dp[n][target]!=-1)
            return dp[n][target];
        
        int count = 0;
        for (int i=1;i<=k;i++) {
            count = (count+solve(n-1,k,target-i,dp))%mod;
        }
        return dp[n][target]=count;
    }
}