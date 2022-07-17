class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        // dp[i][j] stores max side of square possible at i,j in the matrix
        // of first i rows and j columns
        int dp[][] = new int[m][n];
        
        int maxSide = 0;
    
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (i==0 || j==0) {
                    dp[i][j] = matrix[i][j]=='1' ? 1:0;
                }
                else {
                    if (matrix[i][j]=='0')
                        dp[i][j]=0;
                    else
                        dp[i][j]=1+min(dp[i-1][j],dp[i-1][j-1],dp[i][j-1]);
                }
                maxSide=Math.max(maxSide,dp[i][j]);
            }
        }
        
        return maxSide*maxSide;
    }
    
    private int min(int a,int b,int c) {
        return Math.min(a,Math.min(b,c));
    }
}
