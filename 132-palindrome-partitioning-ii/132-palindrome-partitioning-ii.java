class Solution {
    public int minCut(String s) {
        int n = s.length();
        
        // dp[i][j] stores minimum cuts in substring [i,j]
        int dp[][] = new int[n][n];
        for (int i=0;i<n;i++) {
            Arrays.fill(dp[i],-1);
        }
        
        // isPal[i][j] represents if substring [i,j] is palindrome or not
        boolean isPal[][] = new boolean[n][n];
        fillPalindromeTable(s,n,isPal);
        
        return solve(s,0,s.length()-1,dp,isPal);
    }
    
    private int solve(String s,int i,int j,int[][] dp,boolean[][] isPal) {
        if (i>j)
            return 0;
        
        if (dp[i][j]!=-1)
            return dp[i][j];
        
        if (isPal[i][j])
            return dp[i][j]=0;
        
        int minCut = Integer.MAX_VALUE;
        for (int k=i;k<j;k++) {
            
            if (!isPal[i][k]) {
                // OPTIMIZATION
                // If current partition [i,k] is not a palindrome
                // not a valid partition
                // As all cases of partitions in [i,k] except the complete 
                // string [i,k] i.e no partition is already considered
                // Example: bacad
                // Partition at b | acad <--- Case 1
                // Now no need to check partition at ba | cad <--- Case 2
                // This is because ba is not a palindrome
                // And also palindromic partitions of case 2 i.e b|a | c|a|d
                // is already considered in case 1 i.e b | aca|d OR b | a|c|a|d
                continue;
            }
            
            int temp = solve(s,i,k,dp,isPal)+solve(s,k+1,j,dp,isPal)+1;
            minCut = Math.min(minCut,temp);
        }
        
        return dp[i][j]=minCut;
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