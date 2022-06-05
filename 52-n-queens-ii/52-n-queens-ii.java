class Solution {
    int count;
    
    public int totalNQueens(int n) {
        count = 0;
        
        // Chess board - true representing queen exists
        boolean chess[][] = new boolean[n+1][n+1];
        
        /*Queen present in that column or not*/
        boolean col[] = new boolean[n+1];

        /*Queen present in +ve diagonal or not - 
        diagonal represented by sum of row and col coordinates
        possible values are from 2(1+1) to 2*n(n+n) */
        boolean diag45[] = new boolean[2*n+1];

        /*Queen present at negative diagonal or not - 
        diagonal represented by difference of row and col coordinates
        possible values are from 1-n to n-1 
        Shift all values by n-1
        Array size should be (n-1+n-1+1)=(2n-1) */
        boolean diag135[] = new boolean[2*n-1];
        
        placeQueens(chess,n,1,col,diag45,diag135);
        
        return count;
    }
    
    // Placing queens row wise
    public void placeQueens(boolean[][] chess,int n,
                            int rowNum,boolean[] col,boolean[] diag45,boolean[] diag135) {
        
        // Base case
        if (rowNum>n) {
            count++;
            return;
        }
        
        // Placing one by one at each column
        for (int i=1;i<=n;i++) {
            if (!isConflict(chess,rowNum,i,n,col,diag45,diag135)) {
                col[i] = diag45[rowNum+i] = diag135[rowNum-i+n-1] = true;
                chess[rowNum][i]=true;
                placeQueens(chess,n,rowNum+1,col,diag45,diag135);
                chess[rowNum][i]=false;
                col[i] = diag45[rowNum+i] = diag135[rowNum-i+n-1] = false;
            }
        }
    }
    
    // Check whether conflict exists at pos (x,y)
    public boolean isConflict(boolean[][] chess,int x,int y,int n,
                             boolean[] col,boolean[] diag45,boolean[] diag135) {
        if (col[y] || diag45[x+y] || diag135[x-y+n-1])
            return true;
        return false;      
    }
}