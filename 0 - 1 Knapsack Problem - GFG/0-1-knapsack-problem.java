// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}



// } Driver Code Ends


class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    {
        // dp[i][j] represents the max value for capacity j and 
        // array upto first i items
        int dp[][] = new int[n+1][W+1];
        
        // dp[i][0] is 0 i.e max value is 0 if capacity of knapsack is 0
        // dp[0][i] is 0 i.e max value is 0 if no items present
        
        for (int i=1;i<=n;i++) {
            for (int j=1;j<=W;j++) {
                
                // Weight of ith item
                int currWt = wt[i-1];
                int currPrice = val[i-1];
                
                if (currWt>j) {
                    // Current item greater than capacity
                    // Ignore this item
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    // Current item less than or equal to capacity
                    dp[i][j] = Math.max(dp[i-1][j],currPrice+dp[i-1][j-currWt]);
                }
                
            }
        }

        return dp[n][W];
    } 
}


