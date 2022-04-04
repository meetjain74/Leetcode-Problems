class Solution {
    public int uniquePathsIII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean visited[][] = new boolean[m][n];
        
        int startX=-1,startY=-1;
        int endX=-1,endY=-1;
        int emptySquares=1;
        
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (grid[i][j]==1) {
                    startX=i;
                    startY=j;
                }
                if (grid[i][j]==2) {
                    endX=i;
                    endY=j;
                }
                if (grid[i][j]==0)
                    emptySquares++;
            }
        }
        return getCount(visited,grid,startX,startY,endX,endY,m,n,emptySquares);
    }
    
    public int getCount(boolean[][] visited,int[][] grid,
                       int startX,int startY,int endX,int endY,
                       int m,int n,int empty) {
        if (startX==endX && startY==endY) {
            return (empty==0) ? 1 : 0;
        }
        
        if (startX<0 || startX>=m || startY<0 || startY>=n || grid[startX][startY]==-1) {
            return 0;
        }
        
        if (visited[startX][startY]) {
            return 0;
        }
        
        visited[startX][startY]=true;
        int t=0;
        if (grid[startX][startY]!=-1) {
            t = 
                getCount(visited,grid,startX+1,startY,endX,endY,m,n,empty-1)+
                getCount(visited,grid,startX-1,startY,endX,endY,m,n,empty-1)+
                getCount(visited,grid,startX,startY+1,endX,endY,m,n,empty-1)+
                getCount(visited,grid,startX,startY-1,endX,endY,m,n,empty-1);
        }
        visited[startX][startY]=false;
        
        return t;
    }
}