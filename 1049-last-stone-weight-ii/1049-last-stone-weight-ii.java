/*
Say you have four stones a,b,c,d.
first you smash b against c, you get (b-c)
now you smash (b-c) against a
you get a-(b-c) which is same as (a+c)-(b)
now you smash d against (a+c)-b
you get d-((a+c)-b) which is same as (d+b)-(a+c).
Basically for the given stones we can create two sets,the sum of second set of stones to be subtracted from sum of first one.
ideally we want sum of each set to be sum(stones)/2 so that they cancel each other out.

=> Same as minimum sum partition

*/

class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = sumOfArray(stones);
        
        // Size*Sum
        // dp[i][j] represents if subset sum j possible 
        // considering the first i elements of array
        boolean dp[][] = new boolean[n+1][sum+1];
        
        subsetSum(stones,n,sum,dp);
        
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