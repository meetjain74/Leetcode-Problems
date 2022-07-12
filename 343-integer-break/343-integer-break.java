class Solution {
    public int integerBreak(int n) {
        
        // dp[i] represnets the maximum product for integer i
        int dp[] = new int[n+1];
        Arrays.fill(dp,Integer.MIN_VALUE);
        
        for (int i=2;i<=n;i++) {
            for (int j=1;j<i;j++) {
                // Current - j*(i-j)
                dp[i] = max(dp[i], // Not consider this multiplication
                            j*(i-j), // Consider this multiplication but no further divide
                            j*dp[i-j] // Consider this multiplaction and further divide i-j
                           );
            }
        }
        
        return dp[n];
    }
    
    private int max(int a,int b,int c) {
        return Math.max(a,Math.max(b,c));
    }
}