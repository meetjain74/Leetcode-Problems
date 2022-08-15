class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int dp[][] = new int[nums1.length][nums2.length];
        for (int i=0;i<nums1.length;i++) {
            Arrays.fill(dp[i],-1);
        }
        return solve(nums1,nums2,0,0,dp);
    }
    
    private int solve(int[] nums1,int[] nums2,int i1,int i2,int[][] dp) {
        if (i1>=nums1.length)
            return 0;
        if (i2>=nums2.length)
            return 0;
        
        if (dp[i1][i2]!=-1)
            return dp[i1][i2];
        
        // Create a line
        int val = nums1[i1];
        int index = nums2.length;
        for (int i=i2;i<nums2.length;i++) {
            if (nums2[i]==val) {
                index=i;
                break;
            }
        }
        
        int s1=0;
        if (index!=nums2.length)
            s1 = 1+solve(nums1,nums2,i1+1,index+1,dp);
        
        // Do not create a line
        int s2 = solve(nums1,nums2,i1+1,i2,dp);
        
        return dp[i1][i2]=Math.max(s1,s2);
    }
}