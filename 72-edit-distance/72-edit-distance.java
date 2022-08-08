class Solution {
    public int minDistance(String word1, String word2) {
        if (word1.length()==0)
            return word2.length(); // Insert all characters
        if (word2.length()==0)
            return word1.length(); // Delete all characters
        
        // dp[i][j] represents minimum number of operations to convert
        // word1 of length i to word2 of length j
        int dp[][] = new int[word1.length()+1][word2.length()+1];
        
        for (int i=0;i<=word1.length();i++) {
            dp[i][0]=i;
        }
        for (int j=0;j<=word2.length();j++) {
            dp[0][j]=j;
        }
        
        for (int i=1;i<=word1.length();i++) {
            for (int j=1;j<=word2.length();j++) {
                if (word1.charAt(i-1)==word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }
                else {
                    // Order is delete, insert, update
                    dp[i][j] = 1 + min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1]);
                }
            }
        }
        
        return dp[word1.length()][word2.length()];
    }

    private int min(int a,int b,int c) {
        return Math.min(a,Math.min(b,c));
    }
}