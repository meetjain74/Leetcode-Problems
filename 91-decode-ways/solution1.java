class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        
        // dp[i] represents no of encodings in string s for index [0,i]
        int dp[] = new int[n];
        
        for (int i=0;i<n;i++) {
            if (i==0) {
                int x = s.charAt(i)-'0';
                dp[i] = (x==0) ? 0 : 1;
            }
            else {
                int x = s.charAt(i)-'0';
                int y = s.charAt(i-1)-'0';
                int num = y*10+x;
                
                if (y==0 || num>26) {
                    // Encodings upto previous index and current letter at index i
                    dp[i] = dp[i-1] * ((x==0) ? 0 : 1);
                }
                else {
                    if (i==1)
                        dp[i] = dp[i-1] * ((x==0) ? 0 : 1) + ((num==0) ? 0 : 1);
                    else
                        dp[i] = dp[i-1] * ((x==0) ? 0 : 1) + 
                                dp[i-2] * ((num==0) ? 0 : 1);
                }
            }
        }
        
        return dp[n-1];
    }
}
