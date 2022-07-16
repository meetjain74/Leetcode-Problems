class Solution {
    int MOD = 1000000007;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int dp[][][] = new int[m][n][maxMove+1];
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                Arrays.fill(dp[i][j],-1);
            }
        }
        return dfs(startRow,startColumn,m,n,maxMove,dp);
    }
    
    private int dfs(int i,int j,int m,int n,int k,int[][][] dp) {
        if (k<0)
            return 0;
        
        if (i<0 || i>=m || j<0 || j>=n)
            return 1;
        
        if (dp[i][j][k]!=-1)
            return dp[i][j][k];
        
        int d1 = dfs(i-1,j,m,n,k-1,dp);
        int d2 = dfs(i,j-1,m,n,k-1,dp);
        int d3 = dfs(i+1,j,m,n,k-1,dp);
        int d4 = dfs(i,j+1,m,n,k-1,dp);
        
        int ans = ((d1+d2)%MOD + (d3+d4)%MOD)%MOD;
        return dp[i][j][k]=ans;
    }
}