class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int islands = 0;
        int m = grid.length;
        int n = grid[0].length;
        
        int maxArea = 0;
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (grid[i][j]!=2 && grid[i][j]!=0) { // Not visited
                    int currArea = dfs(grid,i,j,m,n);
                    maxArea = Math.max(maxArea,currArea);
                }
            }
        }
        
        return maxArea;
    }
    
    private int dfs(int[][] grid,int currX,int currY,int m,int n) {
        if (currX<0 || currY<0 || currX>=m || currY>=n || grid[currX][currY]!=1)
            return 0;
        
        grid[currX][currY]=2; // Mark land visited
        
        int t=dfs(grid,currX-1,currY,m,n); // Top
        int l=dfs(grid,currX,currY-1,m,n); // Left
        int r=dfs(grid,currX,currY+1,m,n); // Right
        int d=dfs(grid,currX+1,currY,m,n); // Down
        
        return t+l+d+r+1;
    }
}