class Solution {
    public int combinationSum4(int[] nums, int target) {
        return method2(nums,target);
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
    
    // Bottom up DP
    private int method2(int[] nums,int target) {
        // dp[i] represents no of combinations for target i
        int dp[] = new int[target+1];
        
        dp[0]=1;
        
        for (int i=1;i<=target;i++) {
            
            for (int j=0;j<nums.length;j++) {
                if (i-nums[j]>=0)
                    dp[i] += dp[i-nums[j]];
            }
            
        }
        
        return dp[target];
    }
}