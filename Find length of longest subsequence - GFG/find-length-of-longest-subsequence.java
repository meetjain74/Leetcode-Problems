// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int M = Integer.parseInt(input_line[1]);
            input_line = read.readLine().trim().split("\\s+");
            String X = input_line[0];
            String Y = input_line[1];
            Solution obj = new Solution();
            int ans = obj.maxSubsequenceSubstring(X, Y, N, M); 
            System.out.println(ans);
        }
    } 
} // } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    int maxSubsequenceSubstring(String X, String Y, int m, int n) 
    {
        // dp[i][j] represents the length of longest subsequence of X 
        // which is substring in Y
        // for string1 upto length i
        // and string2 upto length j
        int dp[][] = new int[m+1][n+1];
        
        // dp[i][0] is 0 as string2 is empty
        // dp[0][j] is 0 as string1 is empty
        
        int maxLen = 0; // Stores length of longest common substring
        for (int i=1;i<=m;i++) {
            for (int j=1;j<=n;j++) {
                if (X.charAt(i-1)==Y.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = dp[i-1][j];
                    
                maxLen = Math.max(maxLen,dp[i][j]);
            }
        }
        
        return maxLen;
    }
} 