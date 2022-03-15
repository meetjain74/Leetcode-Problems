class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix[0].length;
        
        // Finding tranpose of matrix
        for (int i=0;i<n;i++) {
            for (int j=i+1;j<n;j++) {
                int temp = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
         
        // Reverse the columns
        for (int i=0;i<n/2;i++) {
            swapColumns(matrix,i,n); 
        }
    }
    
    // Swap column col and n-col-1
    public static void swapColumns(int mat[][],int col,int n) {
        for (int i=0;i<n;i++) {
            int temp = mat[i][col];
            mat[i][col] = mat[i][n-col-1];
            mat[i][n-col-1] = temp;
        }
    }
}