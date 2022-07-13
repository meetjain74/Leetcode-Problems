class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        
        // dp[i][j] represents the LCS for string1 upto length i
        // and string2 upto length j
        int dp[][] = new int[m+1][n+1];
        
        // dp[i][0] is 0 as LCS of string1 with empty string is 0
        // dp[0][j] is 0 as LCS of string2 with empty string is 0
        
        for (int i=1;i<=m;i++) {
            for (int j=1;j<=n;j++) {
                if (text1.charAt(i-1)==text2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }
        
        //printLCS(dp,text1,text2,m,n);
        
        return dp[m][n];
    }
    
    private void printLCS(int[][] dp,String text1,String text2,int m,int n) {
        int i=m;
        int j=n;
        
        String str="";
        while(i>0 && j>0) {
            if (text1.charAt(i-1)==text2.charAt(j-1)) {
                str = text1.charAt(i-1)+str;
                i--;
                j--;
            }
            else {
                if (dp[i-1][j]>dp[i][j-1])
                    i--;
                else
                    j--;
            }
        }
        
        System.out.println(str);
    }
}