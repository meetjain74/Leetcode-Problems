class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int dp[][][] = new int[strs.length][m+1][n+1];
        for (int i=0;i<strs.length;i++) {
            for (int j=0;j<=m;j++) {
                Arrays.fill(dp[i][j],-1);
            }    
        }
        
        return helper(strs,0,m,n,dp);
    }
    
    private int helper(String[] strs,int index,int m,int n,int[][][] dp) {
        if (index==strs.length)
            return 0;
        
        if (dp[index][m][n]!=-1)
            return dp[index][m][n];
        
        String curr = strs[index];
        int currM = 0;
        int currN = 0;
        for (char ch: curr.toCharArray()) {
            if (ch=='0') currM++;
            else currN++;
        }
        
        if (currM>m || currN>n) {
            // Need to ignore this string
            return dp[index][m][n]=helper(strs,index+1,m,n,dp);
        }
        
        // Now two paths
        
        // Ignore this string
        int h1 = helper(strs,index+1,m,n,dp);
        
        // Consider this string
        int h2 = 1 + helper(strs,index+1,m-currM,n-currN,dp);
        
        return dp[index][m][n]=Math.max(h1,h2);
    }
}