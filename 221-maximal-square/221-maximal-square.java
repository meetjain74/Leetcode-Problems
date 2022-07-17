class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        // dp[j] stores max side of square possible at j in the matrix
        // of first j columns
        int dp[] = new int[n];
        int prev[] = new int[n];
        
        int maxSide = 0;
    
        for (int i=0;i<m;i++) {
            dp=new int[n];
            for (int j=0;j<n;j++) {
                if (i==0 || j==0) {
                    dp[j] = matrix[i][j]=='1' ? 1:0;
                }
                else {
                    if (matrix[i][j]=='0')
                        dp[j]=0;
                    else
                        dp[j]=1+min(prev[j],prev[j-1],dp[j-1]);
                } 
                 maxSide=Math.max(maxSide,dp[j]);
            }
            prev=dp;
        }
        
        return maxSide*maxSide;
    }
    
    private int min(int a,int b,int c) {
        return Math.min(a,Math.min(b,c));
    }
}