class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[n-1]=0;
        for (int i=n-2;i>=0;i--) {
            int curr = nums[i];
            for (int j=1;j<=curr;j++) {
                if (i+j<n && dp[i+j]!=Integer.MAX_VALUE) {
                    dp[i]=Math.min(dp[i],1+dp[i+j]);
                }
            }
        }
        return dp[0];
    }
}