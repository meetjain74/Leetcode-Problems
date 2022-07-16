class Solution {
    public boolean checkPartitioning(String s) {
        int n = s.length();
        
        // isPal[i][j] represents if substring [i,j] is palindrome or not
        boolean isPalindrome[][] = new boolean[n][n];
        fillPalindromeTable(s,n,isPalindrome);
        return solve(s,isPalindrome);
    }
    
    private boolean solve(String s,boolean[][] isPalindrome) {
        int n = s.length();
        for (int i=0;i<n;i++) {
            for (int j=i+1;j<n-1;j++) {
                if (isPalindrome[0][i] && isPalindrome[i+1][j] && isPalindrome[j+1][n-1])
                    return true;
            }
        }
        return false;
    }
        
    
    private void fillPalindromeTable(String s,int n,boolean[][] dp) {
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
    }
}