class Solution {
    public int palindromePartition(String s, int k) {
        int n = s.length();
        
        // dp[i][j][k] represents minimum number of characters to change
        // in [i,j] to divide string into k substrings
        int dp[][][] = new int[n][n][k+1];
        for(int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                Arrays.fill(dp[i][j],-1);
            }
        }
        return solve(s,0,n-1,k,dp);
    }
    
    // Divide string s into k partitions
    private int solve(String s,int i,int j,int k,int[][][] dp) {
        if (i>j)
            return Integer.MAX_VALUE; //No further partitions possible
        
        if (dp[i][j][k]!=-1)
            return dp[i][j][k];
        
        if (k==1) // No further divide required
            return dp[i][j][k]=getCharactersToChange(s,i,j);
        
        int minChange = Integer.MAX_VALUE;
        
        // Divide string into partitions
        for (int p=i;p<j;p++) {
            int a = solve(s,i,p,1,dp);
            int b = solve(s,p+1,j,k-1,dp);
            if (a==Integer.MAX_VALUE || b==Integer.MAX_VALUE)
                continue;
            minChange=Math.min(minChange,a+b);
        }
        
        return dp[i][j][k]=minChange;
    }
    
    // Returns the number of characters to change to make s palindrome
    private int getCharactersToChange(String s,int i,int j) {
        int change = 0;
        while (i<j) {
            if (s.charAt(i)!=s.charAt(j))
                change++;
            i++;
            j--;
        }
        return change;
    }
}