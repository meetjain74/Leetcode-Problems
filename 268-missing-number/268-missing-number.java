class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        
        // Sum of numbers from 0 to n
        int sum = n*(n+1)/2;
        
        // Sum of array
        int runningSum = 0;
        for (int i=0;i<n;i++) {
            runningSum += nums[i];
        }
        
        return sum-runningSum;
    }
}