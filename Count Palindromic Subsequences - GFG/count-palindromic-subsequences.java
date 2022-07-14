// { Driver Code Starts
import java.util.*;
class GFG
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			//System.out.println(str.length());
			Solution ob  = new Solution();
			System.out.println(ob.countPS(str));
		t--;
		}
	}
}// } Driver Code Ends


/*You are required to complete below method */

class Solution
{
    int MOD = 1000000007;
    long countPS(String str)
    {
        int n = str.length();
        
        // dp[i][j] represents the count of palindromic 
        // subsequences in string from i,j i.e [i,j]
        long dp[][] = new long[n][n];
        
        // Initialization
        // Diagonal elements will be 1 because 1 length string is palindromic
        for (int i=0;i<n;i++) {
            dp[i][i]=1;
        }
        
        // Length 2 substrings 
        // If both characters equal - 3 palindromic subsequences
        // Else - 2 palindromic sequences
        for (int i=0;i<n-1;i++) {
            int j = i+1;
            dp[i][j] = str.charAt(i)==str.charAt(j) ? 3 : 2;
        }
        
        // g represents length-1
        for (int g=2;g<n;g++) {
            for (int i=0,j=g;j<n;i++,j++) {
                if (str.charAt(i)==str.charAt(j)) {
                    dp[i][j] = (dp[i+1][j] + dp[i][j-1] + 1)%MOD;
                }
                else {
                    dp[i][j] = (dp[i+1][j] + dp[i][j-1] - dp[i+1][j-1] + MOD)%MOD;
                }
            }
        }
        
        return dp[0][n-1];
    }
}