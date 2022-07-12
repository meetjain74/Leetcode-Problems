class Solution {
    public int combinationSum4(int[] nums, int target) {
        return method1(nums,target);
    }
    
    // Using memo+recursion
    private int method1(int[] nums, int target) {
        // dp[i] represents no of combinations for target i
        int dp[] = new int[target+1];
        Arrays.fill(dp,-1);
        return helper(nums,target,dp);
    }
    
    private int helper(int[] nums,int target,int dp[]) {
        if (target<0)
            return 0;
        
        if (target==0)
            return 1;
        
        if (dp[target]!=-1)
            return dp[target];
        
        int count = 0;
        for (int i=0;i<nums.length;i++) {
            count += helper(nums,target-nums[i],dp);
        }
        
        return dp[target]=count;
    }
}