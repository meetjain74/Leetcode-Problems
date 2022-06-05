class Solution {
    public void solveSudoku(char[][] board) {
        helper(board,0,0);
    }
    
    private boolean helper(char[][] board, int currRow, int currCol) {
        if (currCol==9) {
            currRow += 1;
            currCol = 0;
        }
        
        if (currRow==9) {
            return true;
        }
        
        if (board[currRow][currCol]=='.') {
            for (int i=1;i<=9;i++) {
                char num = (char)(i+'0');
                if (isValid(board, currRow, currCol, num)) {
                    board[currRow][currCol]=num;
                    if (helper(board,currRow,currCol+1)) {
                        return true;
                    }
                    board[currRow][currCol]='.';
                }
            }
        }
        else {
            return helper(board,currRow,currCol+1);
        }
        
        return false;
    }
    
    // Determines if number num is valid at position (row,col) or not
    private boolean isValid(char[][] board, int row, int col, char num) {
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
        
        return true;
    }
}