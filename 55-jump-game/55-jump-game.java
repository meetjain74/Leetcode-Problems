class Solution {
    public boolean canJump(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp,-1);
        return helper(nums,0,dp);
    }
    
    private boolean helper(int[] nums,int index,int[] dp) {
        if (index>=nums.length)
            return false;
        
        if (index==nums.length-1)
            return true;
        
        if (dp[index]!=-1) {
            return dp[index]==1;
        }
        
        for (int i=1;i<=nums[index];i++) {
            if (helper(nums,index+i,dp)) {
                dp[index]=1;
                return true;
            }
        }
        
        dp[index]=0;
        return false;
    }
}