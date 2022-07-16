class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        
        // dp[i] represents length of longest increasing subsequence
        // that ends at index i (index i is included in lis at dp[i])
        int dp[] = new int[n];
        Arrays.fill(dp,1); // 1 length subsequence
        
        int lis = 1;
        for (int i=1;i<n;i++) {
            for (int prev=0;prev<i;prev++) {
                if (nums[i]>nums[prev])
                    dp[i] = Math.max(dp[i],1+dp[prev]);
            }
            lis = Math.max(lis,dp[i]); // Update Max length increasing subsequence   
        }
        
        return lis;
    }
}