class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        int start = 0;
        int end = 0;
        int product = 1;
        while (end<nums.length) {
            product = product*nums[end];
            if (product>=k) {
                while (start<=end && product>=k) {
                    product=product/nums[start];
                    // Consider number from start to end-1
                    // All subarrays including start is a valid answer
                    count += end-start;
                    start++;
                }
            }
            end++;
        }
        
        if (product<k) {
            // Consider all subarrays possible in array [start,end)
            int n = end-start;
            count += n*(n+1)/2;
        }
        
        return count;
    }
}



