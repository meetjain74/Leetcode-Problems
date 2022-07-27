class Solution {
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int maxVisit = 1; //max indices that can be visited
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        for (int i=0;i<n;i++) {
            int currVisit = dfs(arr,n,d,i,dp);
            maxVisit = Math.max(maxVisit,currVisit);
        }
        return maxVisit;
    }
    
    private int dfs(int[] arr,int n,int d,int curr,int[] dp) {
        if (dp[curr]!=-1)
            return dp[curr];
        
        int max = 1;
        int temp;
        for (int i=curr+1;i<=Math.min(curr+d,n-1) && arr[curr]>arr[i];i++) {
            temp = 1+dfs(arr,n,d,i,dp);
            max = Math.max(max,temp);
        }
        for (int i=curr-1;i>=Math.max(curr-d,0) && arr[curr]>arr[i];i--) {
            temp = 1+dfs(arr,n,d,i,dp);
            max = Math.max(max,temp);
        }
        
        return dp[curr]=max;
    }
}