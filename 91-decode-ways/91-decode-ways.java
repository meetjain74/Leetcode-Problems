class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        
        if (s.charAt(0)=='0')
            return 0;
        
        // dp[i] represents no of encodings upto length i
        int dp[] = new int[n+1];
        dp[0] = 1; // 1 encoding upto no length
        dp[1] = 1; // 1 encoding upto 1 length as now that num>0
        
        for (int i=2;i<=n;i++) {
            if (s.charAt(i-1)>'0'){
                dp[i] = dp[i-1];
            }
            
            if(s.charAt(i-2)=='1' || s.charAt(i-2)=='2' && s.charAt(i-1)<'7') {
                dp[i] += dp[i-2];
            }
        }
        
        return dp[n];
    }
}