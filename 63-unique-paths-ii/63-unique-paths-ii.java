class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        // Obstacle present at start or end
        if (obstacleGrid[0][0]==1 || obstacleGrid[m-1][n-1]==1)
            return 0;
        
        // Dp array representing no of paths starting from that point (i,j) to finish
        int dp[][] = new int[m][n];
        
        for (int i=m-1;i>=0;i--) {
            for(int j=n-1;j>=0;j--) {
                if (i==m-1 && j==n-1) {
                    dp[i][j] = 1;
                    //dp[i][j] = obstacleGrid[i][j]!=1 ? 1 : 0;
                }
                else {
                    int t1 = (i+1)<m && obstacleGrid[i+1][j]!=1 ? dp[i+1][j] : 0;
                    int t2 = (j+1)<n && obstacleGrid[i][j+1]!=1 ? dp[i][j+1] : 0;
                    dp[i][j] = t1+t2;
                }  
            }
        }
        
        return dp[0][0];
    }
}