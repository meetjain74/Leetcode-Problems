class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i=0;i<9;i++) {
            for (int j=0;j<9;j++) {
                if (board[i][j]!='.' && !isValid(board,i,j,board[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }
    
    // Determines if number num is valid at position (row,col) or not
    private boolean isValid(char[][] board, int row, int col, char num) {
        board[row][col] = '.'; // To pass check on itself
        
        //Number should not be present in that row
        for (int j=0;j<9;j++) {
            if (board[row][j]==num) {
                return false;
            }
        }
        
        // Number should not be present in that column
        for (int i=0;i<9;i++) {
            if (board[i][col]==num) {
                return false;
            }
        }
        
        // Number should not be present in the corresponding sub-block of 3*3
        int subBlockRow = row/3;
        int subBlockCol = col/3;
        
        for (int i=0;i<3;i++) {
            int posRow = subBlockRow*3+i;
            for (int j=0;j<3;j++) {
                int posCol = subBlockCol*3+j;
                if (board[posRow][posCol]==num) {
                    return false;
                }
            }
        }
        
        board[row][col] = num; // Again correcting the board matrix
        return true;
    }
}