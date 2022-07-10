// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int knapSack(int N, int W, int val[], int wt[])
    {
        // dp[i][j] represents the max value for capacity j and 
        // array upto first i items
        int dp[][] = new int[N+1][W+1];
        
        // dp[i][0] is 0 i.e max value is 0 if capacity of knapsack is 0
        // dp[0][i] is 0 i.e max value is 0 if no items present 
        
        for (int i=1;i<=N;i++) {
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
                    dp[i][j] = Math.max(dp[i-1][j],currPrice+dp[i][j-currWt]);
                }
                
            }
        }
        
        return dp[N][W];
    }
}