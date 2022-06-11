class Solution {
    public int minOperations(int[] nums, int x) {
        // Return -1 if both array starts and ends with number greater than x
        int n = nums.length;
        if (nums[0]>x && nums[n-1]>x)
            return -1;
        
        // Find the sum of the array
        int sum = getSumOfArray(nums);
        if (sum==x)
            return n;
        
        // We need to find the maximum subarray length with sum k where k = sum-x
        int k = sum-x;
        
        int maxLenSubarray = getMaxLenSubarray(nums,k);
        
        if (maxLenSubarray==0)
            return -1;
        
        return n-maxLenSubarray;
    }
    
    private int getSumOfArray(int[] nums) {
        int sum=0;
        for (int i=0,size=nums.length;i<size;i++) {
            sum += nums[i];
        }
        return sum;
    }
    
    private int getMaxLenSubarray(int[] nums,int k) {
        int maxLen=0;
        int start=0;
        
        int runningSum = 0;
        for (int end=0,size=nums.length;end<size;end++) {
            runningSum += nums[end];
            while (start<end && runningSum>k) {
                runningSum -= nums[start];
                start++;
            }
            
            if (runningSum==k) {
                maxLen = Math.max(maxLen, end-start+1);
            }
        }
        return maxLen;
    }
}