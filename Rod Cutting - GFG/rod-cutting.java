// { Driver Code Starts

import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int n) {
        // Similar to unbounded knapsack
        // Divide rod into pieces which have maximum price
        // Each length piece can be repeated any no of times
        
        // dp[i][j] represents the max value for length j and 
        // considering dividing using first i length pieces
        int dp[][] = new int[n+1][n+1];
        
        // dp[i][0] is 0 i.e max value is 0 if length of rod is 0
        // dp[0][i] is 0 i.e max value is 0 if rod cannot be broken 
        
        for (int i=1;i<=n;i++) {
            for (int j=1;j<=n;j++) {
                
                // Value of ith item
                int curr = price[i-1];
                
                if (i>j) {
                    // Current length greater than rod length
                    // Ignore this length
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    // Current length less than or equal to rod length
                    dp[i][j] = Math.max(dp[i-1][j],curr+dp[i][j-i]);
                }
                
            }
        }
        
        return dp[n][n];
    }
}