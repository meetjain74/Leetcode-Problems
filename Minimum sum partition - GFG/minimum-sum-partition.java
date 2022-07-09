// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    // } Driver Code Ends


//User function Template for Java

class Solution
{
	public int minDifference(int arr[], int n) 
	{ 
	    int sum = sumOfArray(arr);
	    
	    // Size*Sum
        // dp[i][j] represents if subset sum j possible 
        // considering the first i elements of array
        boolean dp[][] = new boolean[n+1][sum+1];
        
        subsetSum(arr,n,sum,dp);
        
        int minDiff = Integer.MAX_VALUE;
        
        // Divide array into two subsets - S1 and S2
        // such that S1-S2 is minimum
        // Check for every possible subset sum 
        // S1+S2=Sum of Array
        // Change values of S1 until sum/2
        
        for (int s1=0;s1<=sum/2;s1++) {
            // S1 sum = s1 - Check if possible
            if (dp[n][s1]) {
                // S2 sum = Array sum - s1
                int s2 = sum-s1;
                minDiff = Math.min(minDiff,s2-s1);
            }
        }
        
        return minDiff;
	}
	
	private int sumOfArray(int arr[]) {
	    int sum = 0;
	    for (int a:arr) {
	        sum += a;
	    }
	    return sum;
	}
	
	private void subsetSum(int[] arr,int N,int sum,boolean[][] dp) {
	    // dp[i][0] is true because take no elements 
        for (int i=0;i<=N;i++) {
            dp[i][0]=true;
        }
        
        // dp[0][j] is false because cannot create sum j with no elements
        
        for (int i=1;i<=N;i++) {
            for (int j=1;j<=sum;j++) {
                
                int curr = arr[i-1];
                if (curr>j) {
                    // Ignore this element
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    // Either ignore this element or take this element
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-curr];
                }
                
            }
        }
	}
}
