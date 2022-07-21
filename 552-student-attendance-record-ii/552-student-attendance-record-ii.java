class Solution {
    int mod = 1000000007;
    public int checkRecord(int n) {
        int dp[][][] = new int[n+1][2][3];
        for (int i=0;i<=n;i++) {
            Arrays.fill(dp[i][0],-1);
            Arrays.fill(dp[i][1],-1);
        }
        return solve(n,0,0,dp);
    }
    
    private int solve(int n,int absent,int late,int[][][] dp) {        
        if (absent>=2 || late>=3)
            return 0;
        
        if (n==0)
            return 1;
        
        if (dp[n][absent][late]!=-1)
            return dp[n][absent][late];
       
        // Present
        int p = solve(n-1,absent,0,dp);
        
        // Absent
        int a = solve(n-1,absent+1,0,dp);
        
        // Late
        int l = solve(n-1,absent,late+1,dp);
        
        return dp[n][absent][late]=((p+a)%mod+l)%mod;
    }
}