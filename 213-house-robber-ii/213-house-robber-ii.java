class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        
        // Represents max profit upto house i excluding last house
        int dp1[] = new int[n];
        
        // Represents max profit upto house i excluding first house
        int dp2[] = new int[n];
        
        dp1[0] = nums[0];
        dp2[0] = Integer.MIN_VALUE;
        
        for (int i=1;i<n;i++) {
            if (i==1) {
                dp1[i] = Math.max(dp1[i-1],nums[i]);
                dp2[i] = nums[i];
            }
            else if (i==2) {
                if (i==n-1) 
                    dp1[i] = dp1[i-1];
                else  
                    dp1[i] = Math.max(dp1[i-1],dp1[i-2]+nums[i]);
                dp2[i] = Math.max(dp2[i-1],nums[i]);
            }
            else if (i==n-1) {
                dp1[i] = dp1[i-1];
                dp2[i] = Math.max(dp2[i-1],dp2[i-2]+nums[i]);
            }
            else {
                dp1[i] = Math.max(dp1[i-1],dp1[i-2]+nums[i]);
                dp2[i] = Math.max(dp2[i-1],dp2[i-2]+nums[i]);
            }
        }
        
        //System.out.println(Arrays.toString(dp1)+" "+Arrays.toString(dp2));
        return Math.max(dp1[n-1],dp2[n-1]);
    }
}