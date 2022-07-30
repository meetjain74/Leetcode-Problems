class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length;
        int n = board[0].length;
        int x = click[0];
        int y = click[1];
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1},
                        {1,1},{1,-1},{-1,1},{-1,-1}};
        
        if (board[x][y]=='M') {
            board[x][y]='X';
            return board;
        }
        
        dfs(board,x,y,m,n,dirs);
        return board;
    }
    
    private void dfs(char[][] board,int x,int y,int m,int n,int[][] dirs) {
        if (x<0 || x>=m || y<0 || y>=n || board[x][y]!='E') {
            return;
        }
        
        // Get count of adjacent mines
        int mines = getAdjacentMinesCount(board,x,y,m,n,dirs);
        if (mines>0) {
            board[x][y] = (char)(mines+'0');
        }
        else {
            // No mines adjacent - Recursively move further
            board[x][y]='B';
            for (int[] dir: dirs) {
                int x1 = x+dir[0];
                int y1 = y+dir[1];
                dfs(board,x1,y1,m,n,dirs);
            }
        }
    }
    
    private int getAdjacentMinesCount(char[][] board,int x,int y,
                                      int m,int n,int[][] dirs) {
        int count = 0;
        for (int[] dir: dirs) {
            int x1 = x+dir[0];
            int y1 = y+dir[1];
            
            if (x1<0 || x1>=m || y1<0 || y1>=n) {
                continue;
            }
            
            if (board[x1][y1]=='M')
                count++;
        }
        
        return count;
    }
}