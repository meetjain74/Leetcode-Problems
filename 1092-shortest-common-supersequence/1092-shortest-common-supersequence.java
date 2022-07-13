class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        
        // Get length of shortest common supersequence
        // dp[i][j] represents length of shortest common supersequence
        // of X upto length i and Y upto length j
        int dp[][] = new int[m+1][n+1];
        
        // dp[i][0] is i as SCS of string1 with empty string is i
        for (int i=0;i<=m;i++) {
            dp[i][0]=i;
        }
        
        // dp[0][j] is j as SCS of string2 with empty string is j
        for (int j=0;j<=n;j++) {
            dp[0][j]=j;
        }
        
        for (int i=1;i<=m;i++) {
            for (int j=1;j<=n;j++) {
                if (str1.charAt(i-1)==str2.charAt(j-1)) {
                    // Both characters are equal - Take only one in supersequence
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else {
                    dp[i][j]=Math.min(1+dp[i][j-1],1+dp[i-1][j]);
                }
            }
        }
        
        String scs = "";
        int i = m;
        int j = n;
        
        while (i>0 && j>0) {
            if (str1.charAt(i-1)==str2.charAt(j-1)) {
                scs = str1.charAt(i-1)+scs;
                i--;
                j--;
            }
            else {
                // Get min of (i-1,j) and (i,j-1)
                if (dp[i-1][j]<dp[i][j-1]) {
                    scs = str1.charAt(i-1)+scs;
                    i--;
                }
                else {
                    scs = str2.charAt(j-1)+scs;
                    j--;
                }
            }
        }
        
        while (i>0) {
            scs = str1.charAt(i-1)+scs;
            i--;
        }
        
        while (j>0) {
            scs = str2.charAt(j-1)+scs;
            j--;
        }
         
        return scs;
    }
}