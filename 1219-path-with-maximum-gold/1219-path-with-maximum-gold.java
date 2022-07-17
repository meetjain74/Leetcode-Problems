class Solution {
    public int getMaximumGold(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int maxGold = 0;
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (grid[i][j]!=0) {
                    int gold = dfs(grid,i,j,new boolean[m][n]);
                    maxGold = Math.max(maxGold,gold);
                }
            }
        }
        
        return maxGold;
    }
    
    private int dfs(int[][] grid,int i,int j,boolean[][] visited) {
        if (i<0 || i>=grid.length || j<0 || j>=grid[0].length || 
           visited[i][j] || grid[i][j]==0)
            return 0;
        
        visited[i][j] = true;
        int d1 = dfs(grid,i-1,j,visited); //top
        int d2 = dfs(grid,i,j-1,visited); //left
        int d3 = dfs(grid,i+1,j,visited); //down
        int d4 = dfs(grid,i,j+1,visited); //right
        visited[i][j] = false;
        
        return grid[i][j] + max(d1,d2,d3,d4);
    }
    
    private int max(int a,int b,int c,int d) {
        return Math.max(a,Math.max(b,Math.max(c,d)));
    }
}