class Solution {
    public boolean containsCycle(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        
        // Stores whether cycle exists from i,j as root -> 1 true, 0 false
        int dp[][] = new int[m][n];
        for (int i=0;i<m;i++) {
            Arrays.fill(dp[i],-1);
        }
        
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (dp[i][j]==-1) {
                    if (checkCycle(grid,dp,i,j,m,n,grid[i][j],-1,-1))
                        return true;
                }
            }
        }
        
        return false;
    }
    
    // DFS
    private boolean checkCycle(char[][] grid,int[][] dp,
                              int currX,int currY,int m,int n,char prev,
                              int prevX,int prevY) {
        
        if (currX<0 || currX>=m || currY<0 || currY>=n || grid[currX][currY]!=prev)
            return false;
        
        if (dp[currX][currY]!=-1)
            return dp[currX][currY]==1;
        
        dp[currX][currY]=1;
        
        // Top
        if (currX-1!=prevX && 
            checkCycle(grid,dp,currX-1,currY,m,n,grid[currX][currY],currX,currY)) {
            dp[currX][currY]=1;
            return true;
        }
        
        // Left
        if (currY-1!=prevY && 
            checkCycle(grid,dp,currX,currY-1,m,n,grid[currX][currY],currX,currY)) {
            dp[currX][currY]=1;
            return true;
        }
        
        // Right
        if (currY+1!=prevY && 
            checkCycle(grid,dp,currX,currY+1,m,n,grid[currX][currY],currX,currY)) {
            dp[currX][currY]=1;
            return true;
        }
        
        // Down
        if (currX+1!=prevX && 
             checkCycle(grid,dp,currX+1,currY,m,n,grid[currX][currY],currX,currY)) {
            dp[currX][currY]=1;
            return true;
        }
        
        dp[currX][currY]=0;
        return false;
    }
}