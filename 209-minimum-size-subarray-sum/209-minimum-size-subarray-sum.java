class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        
        int start=0;
        int end=0;
        
        int minLen = Integer.MAX_VALUE;
        int runningSum=0;
        while (end<n) {
            runningSum+=nums[end];
            if (runningSum<target) {
                end++;
            }
            else if (runningSum>=target) {
                while (start<=end && runningSum>=target) {
                    minLen=Math.min(minLen,end-start+1);
                    runningSum-=nums[start];
                    start++;
                }
                end++;
            }
        }
        
        return minLen==Integer.MAX_VALUE ? 0 : minLen;
    }
}