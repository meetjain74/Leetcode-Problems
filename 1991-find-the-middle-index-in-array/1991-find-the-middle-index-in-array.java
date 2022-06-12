class Solution {
    public int findMiddleIndex(int[] nums) {
        // Find the complete sum of array
        int prefixSum = 0;
        for (int i=0,size=nums.length;i<size;i++) {
            prefixSum += nums[i];
        }
        
        int runningSum = 0;
        for (int i=0,size=nums.length;i<size;i++) {
            runningSum += nums[i];
            if (runningSum == prefixSum+nums[i]-runningSum)
                return i;
        } 
        
        return -1;
    }
}