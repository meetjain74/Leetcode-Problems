class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        
        // If array contains all negative elements
        int neg = isNegative(nums);
        if (neg!=0)
            return neg;
        
        // Now find maximum circular subarray sum
        
        // Find maximum circular subarray sum in normal array (not circular)
        int max1 = maxSubarraySum(nums);
        
        // Maximum subarray sum with elements from opp sides of array
        // Find sum of array and minimum subarray sum of normal array
        // Difference of sum of array and minimum subarray is answer
        int sum = getSumArray(nums);
        int min = minSubarraySum(nums);
        int max2 = sum-min;
        
        return Math.max(max1,max2);
    }
    
    // Check if array contains all negative elements
    // Then returns the max value else return 0
    private int isNegative(int[] nums) {
        int maxNegative = Integer.MIN_VALUE;
        boolean isNegative = true;
        for (int num: nums) {
            if (num>0) {
                isNegative=false;
                break;
            }
            maxNegative = Math.max(maxNegative,num);
        }
        
        if (isNegative)
            return maxNegative;
        
        return 0;
    }
    
    private int getSumArray(int[] nums) {
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }
        return sum;
    }
    
    // Kadane algorithm
    private int maxSubarraySum(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int num: nums) {
            currentSum += num;
            maxSum = Math.max(maxSum,currentSum);
            if (currentSum<0) {
                currentSum=0;
            }
        }
        return maxSum;
    }
    
    // Kadane algorithm
    private int minSubarraySum(int[] nums) {
        int minSum = Integer.MAX_VALUE;
        int currentSum = 0;
        for (int num: nums) {
            currentSum += num;
            minSum = Math.min(minSum,currentSum);
            if (currentSum>0) {
                currentSum=0;
            }
        }
        return minSum;
    }
}