class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][n];
        for (int i=0;i<n;i++) {
            Arrays.fill(dp[i],-1);
        }
        return solve(nums,0,n-1,dp);
    }
    
    private int solve(int[] nums,int i,int j,int[][] dp) {
        if (i>j) {
            return 0;
        }
        
        if (dp[i][j]!=-1)
            return dp[i][j];
        
        int maxCoins = 0;
        
        // We move bottom to up
        for (int k=i;k<=j;k++) {
            // Burst kth balloon in the last step
            int currCoins = getCoins(nums,k,i,j);
            int a = solve(nums,i,k-1,dp);
            int b = solve(nums,k+1,j,dp);
            
            maxCoins = Math.max(currCoins+a+b,maxCoins);
        }
        
        return dp[i][j]=maxCoins;
    }
    
    // Number of coins when burst balloon k
    private int getCoins(int[] nums,int k,int i,int j) {
        int coins = nums[k];
        if (i-1>=0)
            coins *= nums[i-1];
        if (j+1<nums.length)
            coins *= nums[j+1];
        return coins;
    }
}