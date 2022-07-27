class Solution {
    public int jump(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp,-1);
        return helper(nums,0,dp);
    }
    
    private int helper(int[] nums,int index,int[] dp) {
        if (index>=nums.length)
            return Integer.MAX_VALUE;
        
        if (index==nums.length-1)
            return 0;
        
        if (dp[index]!=-1)
            return dp[index];
        
        int curr = nums[index];
        int minMoves = Integer.MAX_VALUE;
        for (int i=1;i<=curr;i++) {
            int h = helper(nums,index+i,dp);
            if (h!=Integer.MAX_VALUE)
                minMoves = Math.min(minMoves,1+h);
        }
        
        return dp[index]=minMoves;
    }
}
