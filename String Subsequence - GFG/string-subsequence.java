// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(in.readLine().trim());
        while (tc-- > 0) {
            String S1 = in.readLine();
            String S2 = in.readLine();
            Solution ob = new Solution();
            System.out.println( ob.countWays(S1,S2) );
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    int countWays(String S1, String S2) { 
        int m = S1.length();
        int n = S2.length();
        
        // dp[i][j] represents count of times string2 occurs in string1
        int dp[][] = new int[m+1][n+1];
        
        // dp[i][0] is 1 as string2 is empty - empty subsequence
        for (int i=0;i<=m;i++) {
            dp[i][0] = 1;
        }
        
        // dp[0][i] is 0 as string1 is empty
        
        for (int i=1;i<=m;i++) {
            for (int j=1;j<=n;j++) {
                if (S1.charAt(i-1)==S2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[m][n];
    }
}