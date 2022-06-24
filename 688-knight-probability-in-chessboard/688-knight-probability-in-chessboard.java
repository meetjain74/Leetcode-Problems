class Solution {    
    public double knightProbability(int n, int k, int row, int column) {
        int[][] dirs = {{1,2},{1,-2},{2,1},{2,-1},
                        {-1,2},{-1,-2},{-2,-1},{-2,1}};
        
        
        // Stores probability of knight at (x,y) and z steps remaining
        double dp[][][] = new double[n][n][k+1];
        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                Arrays.fill(dp[i][j],-1.0);
            }
        }
        
        return getProbability(dp,dirs,n,k,row,column);
    }
    
    private double getProbability(double[][][] dp,int[][] dirs,
                                 int n,int k,int currX,int currY) {
        if (!isPositionValid(n,currX,currY))
            return 0;
        
        if (k==0)
            return 1;
        
        if (dp[currX][currY][k]!=-1) {
            return dp[currX][currY][k];
        }
        
        double probability = 0;
        for (int[] d: dirs) {
            probability += getProbability(dp,dirs,n,k-1,currX+d[0],currY+d[1])/8.0;
        }
        
        dp[currX][currY][k]=probability;
        return probability;
    }
    
    private boolean isPositionValid(int n,int x,int y) {
        if (x<0 || x>=n || y<0 || y>=n)
            return false;
        return true;
    }
}