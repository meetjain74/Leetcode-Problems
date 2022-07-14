class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int dp[][]=new int[n][n];
        
        // dp[i][j] denotes substring starting from index i and ending at index j
        
        int startIndex,endIndex;
        int maxLength;
        int longestPalindromeStartIndex;
          
        // All one letter substrings are palindromic
        // hence dp[i][i] will be 1(true)
        
        for (int i=0;i<n;i++)
            dp[i][i]=1;
        
        maxLength=1;
        longestPalindromeStartIndex=0;
        
        // Two letter substrings will be palindrmic if 
        // both letters are same 
        
        for (int i=0;i<n-1;i++)
        {
            if (s.charAt(i)==s.charAt(i+1))
            {
                dp[i][i+1]=1;
                maxLength=2;
                longestPalindromeStartIndex=i;
            }
        }
        
        // For substrings of length greater than equal to 3 will be palindromic if
        // Substring starts and ends at same value and
        // Substring excluding the start and end value is palindromic
        // For dp[i][j] = 1 -> String[i]==STring[j] and dp[i+1][j-1]==1
        for (int len=3;len<=n;len++)
        {
            for (int i=0;i<n-len+1;i++)
            {
                int j=i+len-1;
                if (s.charAt(i)==s.charAt(j) && dp[i+1][j-1]==1)
                {
                    dp[i][j]=1;
                    maxLength=len;
                    longestPalindromeStartIndex=i;
                }
            }
        }
        
        String longestPalindrome = s.substring(longestPalindromeStartIndex,
                                               longestPalindromeStartIndex+maxLength);
        
        return longestPalindrome;
    }
}
