// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int t=sc.nextInt();
		
		sc.nextLine();
		while(t-->0)
		{
		   //taking String X and Y
		   String S[]=sc.nextLine().split(" ");
		   String X=S[0];
		   String Y=S[1];
		   
		   //calling function shortestCommonSupersequence()
		   System.out.println(new Solution().shortestCommonSupersequence(X, Y, X.length(), Y.length()));
		}
	}




       
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find length of shortest common supersequence of two strings.
    public static int shortestCommonSupersequence(String X,String Y,int m,int n)
    {
        // dp[i][j] represents length of shortest common supersequence
        // of X upto length i and Y upto length j
        int dp[][] = new int[m+1][n+1];
        
        // dp[i][0] is i as SCS of string1 with empty string is i
        for (int i=0;i<=m;i++) {
            dp[i][0]=i;
        }
        
        // dp[0][j] is j as SCS of string2 with empty string is j
        for (int j=0;j<=n;j++) {
            dp[0][j]=j;
        }
        
        for (int i=1;i<=m;i++) {
            for (int j=1;j<=n;j++) {
                if (X.charAt(i-1)==Y.charAt(j-1)) {
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else {
                    dp[i][j]=Math.min(1+dp[i][j-1],1+dp[i-1][j]);
                }
            }
        }
        
        return dp[m][n];
    }
}