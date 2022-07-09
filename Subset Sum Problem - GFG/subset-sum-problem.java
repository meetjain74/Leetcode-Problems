// { Driver Code Starts
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
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static Boolean isSubsetSum(int N, int arr[], int sum){
        
        // Size*Sum
        // dp[i][j] represents if subset sum j possible 
        // considering the first i elements of array
        boolean dp[][] = new boolean[N+1][sum+1];
        
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
        
        return dp[N][sum];
    }
}