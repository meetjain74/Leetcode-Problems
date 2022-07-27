class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        
        // Determines the last index through which we can reach 
        // last index of array
        int lastGoodIndex = n-1; 
        for (int i=n-2;i>=0;i--) {
            int curr = nums[i];
            if (i+nums[i]>=lastGoodIndex) {
                lastGoodIndex=i;
            }
        }
        
        return lastGoodIndex==0;
    }
}