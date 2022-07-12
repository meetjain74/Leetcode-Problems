// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            
            String S1 = read.readLine().trim();
            String S2 = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestCommonSubstr(S1, S2, n, m));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    int longestCommonSubstr(String S1, String S2, int m, int n) {
        // dp[i][j] represents the length of longest common substring
        // for string1 upto length i
        // and string2 upto length j
        int dp[][] = new int[m+1][n+1];
        
        // dp[i][0] is 0 as string2 is empty
        // dp[0][j] is 0 as string1 is empty
        
        int maxLen = 0; // Stores length of longest common substring
        for (int i=1;i<=m;i++) {
            for (int j=1;j<=n;j++) {
                if (S1.charAt(i-1)==S2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = 0;
                    
                maxLen = Math.max(maxLen,dp[i][j]);
            }
        }
        
        return maxLen;
    }
}