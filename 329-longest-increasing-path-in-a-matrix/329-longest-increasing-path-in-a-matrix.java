class Solution {
    
    public int longestIncreasingPath(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int dp[][] = new int[m][n];
        for (int i=0;i<m;i++) {
            Arrays.fill(dp[i],-1);
        }
        
        int maxPath = 0;
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                maxPath=Math.max(maxPath,dfs(dp,matrix,i,j,m,n));
            }
        }
        
        return maxPath;
    }
    
    private int dfs(int dp[][],int matrix[][],int currX,int currY,int m,int n) {
        if (currX<0 || currY<0 || currX>=m || currY>=n)
            return 0;
        
        if (dp[currX][currY]!=-1)
            return dp[currX][currY];
        
        int currentMax = 1;
        
        // Top
        if (currX-1>=0 && matrix[currX-1][currY]>matrix[currX][currY]) {
            currentMax = Math.max(currentMax,1+dfs(dp,matrix,currX-1,currY,m,n));
        }
        
        // Left
        if (currY-1>=0 && matrix[currX][currY-1]>matrix[currX][currY]) {
            currentMax = Math.max(currentMax,1+dfs(dp,matrix,currX,currY-1,m,n));
        }
        
        // Right
        if (currY+1<n && matrix[currX][currY+1]>matrix[currX][currY]) {
            currentMax = Math.max(currentMax,1+dfs(dp,matrix,currX,currY+1,m,n));
        }
        
        // Down
        if (currX+1<m && matrix[currX+1][currY]>matrix[currX][currY]) {
            currentMax = Math.max(currentMax,1+dfs(dp,matrix,currX+1,currY,m,n));
        }
        
        dp[currX][currY] = currentMax;
        return currentMax;
    }
}