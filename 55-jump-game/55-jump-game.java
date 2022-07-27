class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean dp[] = new boolean[n];
        dp[n-1]=true;
        for (int i=n-2;i>=0;i--) {
            int curr = nums[i];
            for (int j=1;j<=curr;j++) {
                if (i+j<n && dp[i+j]) {
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[0];
    }
}