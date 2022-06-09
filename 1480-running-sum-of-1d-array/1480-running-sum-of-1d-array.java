class Solution {
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        int[] runningSums =  new int[n];
        int runningSum = 0;
        for (int i=0;i<n;i++) {
            runningSum += nums[i];
            runningSums[i] = runningSum;
        }
        
        return runningSums;
    }
}