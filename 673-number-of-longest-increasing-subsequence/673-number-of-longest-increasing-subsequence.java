class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        
        // dp[i] represents the length of LIS including ith element of array
        int[] dp = new int[n];
        dp[0]=1; // 1 length LIS
        
        // count[i] stores number of LIS including ith element of array
        int count[] = new int[n];
        count[0]=1;
        
        int lis = 1;
        for (int i=1;i<n;i++) {
            dp[i]=1;
            count[i]=1;
            for (int prev=0;prev<i;prev++) {
                if (nums[i]>nums[prev]) {
                    if (1+dp[prev]>dp[i]) {
                        // Update lis
                        dp[i]=1+dp[prev];
                        count[i]=count[prev];
                    }
                    else if (1+dp[prev]==dp[i]) {
                        // Increase the count if such length lis already exists
                        count[i]+=count[prev];  
                    } 
                }
            }
            lis = Math.max(lis,dp[i]);
        }
        
        int ans = 0;
        for (int i=0;i<n;i++) {
            if (dp[i]==lis)
                ans += count[i];
        }
        
        return ans;
    }
}