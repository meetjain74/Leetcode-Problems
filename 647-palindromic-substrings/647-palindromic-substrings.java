class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        
        // dp[i][j] represents if string [i,j] is palindrome or not
        boolean[][] dp = new boolean[n][n];
        
        // String [i,i] is palindrome
        for (int i=0;i<n;i++) {
            dp[i][i] = true;
        }
        
        // String [i,i+1] is palindrome if both characters are equal
        for (int i=0;i<n-1;i++) {
            dp[i][i+1] = (s.charAt(i)==s.charAt(i+1));
        }
        
        for (int g=2;g<n;g++) {
            for (int i=0,j=g;j<n;i++,j++) {
                if (s.charAt(i)==s.charAt(j))
                    dp[i][j]=dp[i+1][j-1];
                // else
                //     dp[i][j]=false;
            }
        }
        
        // Count palindromic substring now
        int count = 0;
        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                if (dp[i][j])
                    count++;
            }
        }
        
        return count;
    }
}