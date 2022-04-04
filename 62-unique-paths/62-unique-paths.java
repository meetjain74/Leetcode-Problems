class Solution {
    public int uniquePaths(int m, int n) {
        // Dp array representing no of paths starting from that point (i,j) to finish
        int dp[][] = new int[m][n];
        
        for (int i=m-1;i>=0;i--) {
            for(int j=n-1;j>=0;j--) {
                if (i==m-1 && j==n-1) {
                    dp[i][j] = 1;
                }
                else {
                    int t1 = (i+1)<m ? dp[i+1][j] : 0;
                    int t2 = (j+1)<n ? dp[i][j+1] : 0;
                    dp[i][j] = t1+t2;
                }  
            }
        }
        
        return dp[0][0];
    }
}