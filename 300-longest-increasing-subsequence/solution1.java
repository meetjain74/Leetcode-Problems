class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[][] = new int[nums.length][nums.length+1];
        for (int i=0;i<nums.length;i++) {
            Arrays.fill(dp[i],-1);
        }
        return LIS(nums,0,-1,dp);
    }
    
    private int LIS(int[] nums,int index,int prevIndex,int[][] dp) {
        if (index==nums.length)
            return 0;
        
        if (dp[index][prevIndex+1]!=-1)
            return dp[index][prevIndex+1];
        
        // Not take current element
        int notTake = LIS(nums,index+1,prevIndex,dp);
        
        // Take current element if possible
        int take = 0;
        if (prevIndex==-1 || nums[index]>nums[prevIndex]) {
            take = 1 + LIS(nums,index+1,index,dp);
        }
        
        return dp[index][prevIndex+1]=Math.max(take,notTake);
    }
}
