class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int tempSum = 0;
        for (int i: nums) {
            tempSum = Math.max(tempSum+i,i);
            maxSum = Math.max(maxSum,tempSum);
        }
        return maxSum;
    }
}