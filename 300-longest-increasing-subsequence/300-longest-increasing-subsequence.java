class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        
        // dp[i] represents length of longest increasing subsequence
        // that ends at index i (index i is included in lis at dp[i])
        int dp[] = new int[n];
        Arrays.fill(dp,1); // 1 length subsequence 
        
        int prev[] = new int[n]; // Store the prev index for LIS 
        int lastIndex = 0; // Last index for LIS
        
        int lis = 1;
        for (int i=1;i<n;i++) {
            prev[i]=i;
            for (int prv=0;prv<i;prv++) {
                if (nums[i]>nums[prv]) {
                    if (dp[i]<1+dp[prv]) {
                        dp[i] = 1+dp[prv];
                        prev[i] = prv;
                    }
                }
                
            }
            // Update Max length increasing subsequence   
            if (dp[i]>lis) {
                lis = dp[i];
                lastIndex=i;
            }
        }
        
        // Print LIS
        int LIS[] = new int[lis];
        LIS[lis-1] = nums[lastIndex];
        int index=lis-2;
        while (prev[lastIndex]!=lastIndex) {
            lastIndex=prev[lastIndex];
            LIS[index]=nums[lastIndex];
            index--;
        }
        
        //System.out.println(Arrays.toString(LIS));
        
        return lis;
    }
}