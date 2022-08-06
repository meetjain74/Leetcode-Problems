class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        // All O's connected to any boundary point
        // will not be flipped
        
        // DFS on all nodes across the boundary
        boolean[][] visited = new boolean[m][n];
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (i==0 || j==0 || i==m-1 || j==n-1) {
                    // Boundary
                    // Apply DFS if current is O
                    if (board[i][j]=='O') {
                        dfs(board,i,j,m,n,visited);
                    }
                }
            }
        }
        
        // Board contains three chars now- X,O and P
        // Flip O to X and flip P to O
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (board[i][j]=='P') {
                    board[i][j]='O';
                }
                else if (board[i][j]=='O') {
                    board[i][j]='X';
                }
            }
        }
    }
    
    private void dfs(char[][] board,int i,int j,int m,int n,boolean[][] visited) {
        if (i<0 || j<0 || i>=m || j>=n || visited[i][j] || board[i][j]=='X') {
            return;
        }
        
        board[i][j]='P'; // Suggest that this pos cannot be flipped
        visited[i][j]=true;
        dfs(board,i-1,j,m,n,visited);
        dfs(board,i,j-1,m,n,visited);
        dfs(board,i+1,j,m,n,visited);
        dfs(board,i,j+1,m,n,visited);
    }
}