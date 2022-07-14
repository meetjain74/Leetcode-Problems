class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        
        // dp[i][j] stores the count of distinct subsequences of 
        // string1 upto length i which equals string2 upto length j
        int dp[][] = new int [m+1][n+1];
        
        // dp[i][0] is 1 as string2 is empty
        for (int i=0;i<=m;i++) {
            dp[i][0]=1;
        }
        
        // dp[0][j] is 0 as string1 is empty
        
        for (int i=1;i<=m;i++) {
            for (int j=1;j<=n;j++) {
                if (s.charAt(i-1)==t.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        
        return dp[m][n];
    }
}