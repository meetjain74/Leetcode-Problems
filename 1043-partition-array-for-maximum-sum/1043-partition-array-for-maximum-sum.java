class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int dp[][] = new int[n][n];
        for (int i=0;i<n;i++)
            Arrays.fill(dp[i],-1);
        
        return solve(arr,0,n-1,k,dp);
    }
    
    private int solve(int[] arr,int i,int j,int k,int dp[][]) {
        if (i>j)
            return 0;
        
        if (dp[i][j]!=-1)
            return dp[i][j];
        
        int maxSum = 0;
        if (j-i+1<=k) {
            maxSum = (j-i+1)*getMax(arr,i,j);
        }
        
        for (int p=i;p<Math.min(j,i+k);p++) {
            int s1 = (p-i+1)*getMax(arr,i,p);
            int s2 = solve(arr,p+1,j,k,dp);
            int tempSum = s1+s2;
            maxSum = Math.max(maxSum,tempSum);
        }
        
        return dp[i][j]=maxSum;
    }
    
    private int getMax(int arr[],int i,int j) {
        int max = arr[i];
        for (int t=i+1;t<=j;t++) {
            max=Math.max(max,arr[t]);
        }
        return max;
    }
}