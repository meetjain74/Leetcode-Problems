class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums,target,0,0);
    }
    
    private int helper(int[] nums,int target,int current,int index) {
        if (index==nums.length) {
            if (current==target)
                return 1;
            return 0;
        }
        
        int h1 = helper(nums,target,current-nums[index],index+1);
        int h2 = helper(nums,target,current+nums[index],index+1);
        
        return h1+h2;
    }
}