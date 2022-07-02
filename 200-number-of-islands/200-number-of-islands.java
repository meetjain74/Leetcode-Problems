class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;
        int m = grid.length;
        int n = grid[0].length;
        
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (grid[i][j]!='2' && grid[i][j]!='0') { // Not visited
                    islands++;
                    dfs(grid,i,j,m,n);
                }
            }
        }
        
        return islands;
    }
    
    private void dfs(char[][] grid,int currX,int currY,int m,int n) {
        if (currX<0 || currY<0 || currX>=m || currY>=n || 
            grid[currX][currY]=='2' || grid[currX][currY]=='0')
            return;
        
        grid[currX][currY]='2'; // Mark land visited
        
        dfs(grid,currX-1,currY,m,n); // Top
        dfs(grid,currX,currY-1,m,n); // Left
        dfs(grid,currX,currY+1,m,n); // Right
        dfs(grid,currX+1,currY,m,n); // Down
    }
}