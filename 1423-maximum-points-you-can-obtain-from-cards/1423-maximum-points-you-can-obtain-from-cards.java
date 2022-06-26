class Solution {
    public int maxScore(int[] cardPoints, int k) {
        // Max score is total sum - minimum subarray sum of size n-k
        int totalSum = getTotalSum(cardPoints);
        if (k==cardPoints.length)
            return totalSum;
        
        int minSubarraySum = minSubarraySum(cardPoints,cardPoints.length-k);

        return totalSum-minSubarraySum;
    }
    
    // Minimum subarray sum of size k
    private int minSubarraySum(int[] nums,int k) {
        int sum = 0;
        int start = 0;
        int minSum = Integer.MAX_VALUE;
        for (int end=0;end<nums.length;end++) {
            sum=sum+nums[end];
            if (end-start+1==k) {
                minSum = Math.min(sum,minSum);
                sum=sum-nums[start];
                start++;
            }
        }
        
        return minSum;
    }
    
    private int getTotalSum(int[] nums) {
        int sum = 0;
        for (int i: nums) {
            sum += i;
        }
        return sum;
    }
}