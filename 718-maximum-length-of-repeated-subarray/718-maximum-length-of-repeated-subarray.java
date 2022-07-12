class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        // Similar to longest common substring
        
        int m = nums1.length;
        int n = nums2.length;
        
        // dp[i][j] represents the maximum length
        // of repeated subarray for array1 upto length i
        // and array2 upto length j
        int dp[][] = new int[m+1][n+1];
        
        // dp[i][0] is 0 as another array is empty
        // dp[0][j] is 0 as another array is empty
        
        int maxLen = 0; // Stores maximum length of repeated subarray
        for (int i=1;i<=m;i++) {
            for (int j=1;j<=n;j++) {
                if (nums1[i-1]==nums2[j-1])
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = 0;
                
                maxLen = Math.max(maxLen,dp[i][j]);
            }
        }
        
        return maxLen;
    }
}