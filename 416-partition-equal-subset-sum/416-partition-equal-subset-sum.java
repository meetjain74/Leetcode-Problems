class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++) {
            sum+=nums[i];
        }
        
        // If sum is odd, can't be partitioned
        if (sum%2!=0) 
            return false;
        
        // Required subset sum
        int target = sum/2;
        
        return isSubsetSum(nums,target);
    }
    
    public boolean isSubsetSum(int nums[],int target) {
        int size = nums.length;
        
        // DP matrix containing size of arrays rows and target columns from 0
        // dp[i][j] denotes first i items present and find target sum as j using them
        boolean dp[][] = new boolean[size+1][target+1];
        
        // Initialization
        
        // Target sum 0 then always true for any number of elements as not choose any
        for (int i=0;i<=size;i++) {
            dp[i][0] = true;
        }
        
        // Empty array and any target sum greater than 0 false because no elements present
        for (int i=1;i<=target;i++) {
            dp[0][i] = false;
        }
        
        // Iteration
        
        for (int i=1;i<=size;i++) {
            for (int j=1;j<=target;j++) {
                // Element i is present at index i-1 in array
                if (nums[i-1]<=j) {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[size][target];
    }
}