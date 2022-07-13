// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            int n = Integer.parseInt(read.readLine());
            String str = read.readLine().strip();
            Solution ob = new Solution();
            long ans = ob.minDeletions(str, n); 
            System.out.println(ans);
        }
    } 
} // } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    int minDeletions(String str, int n)
    {
        // Delete elements which are not in longest palindromic subsequence
        return n-LPS(str,n);
    }
    
    private int LPS(String s,int n) {
        // Find LCS of s with reverse of s
        String r = reverse(s);
        return LCS(s,r,n,n);
    }
    
    private String reverse(String s) {
        String r = "";
        for (char ch: s.toCharArray()) {
            r = ch+r;
        }
        return r;
    }
    
    private int LCS(String str1, String str2,int m,int n) {
        // dp[i][j] represents the LCS for string1 upto length i
        // and string2 upto length j
        int dp[][] = new int[m+1][n+1];
        
        // dp[i][0] is 0 as LCS of string1 with empty string is 0
        // dp[0][j] is 0 as LCS of string2 with empty string is 0
        for (int i=1;i<=m;i++) {
            for (int j=1;j<=n;j++) {
                if (str1.charAt(i-1)==str2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }
        return dp[m][n];
    }
} 