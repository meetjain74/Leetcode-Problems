class Solution {
    int mod = 1000000007;
    public int distinctSubseqII(String s) {
        int n = s.length();
        
        // dp[i] represents count of distinct subsequences 
        // for length i in string
        int dp[] = new int[n+1];
        dp[0] = 1; // Empty subsequence 
        
        // Store last occurence of every character
        HashMap<Character,Integer> hm = new HashMap<>();
        
        for (int i=1;i<=n;i++) {
            char ch = s.charAt(i-1);
            
            // Consider previous subsequences without current character
            // Consider previous subsequences including current character
            dp[i] = (dp[i-1]+dp[i-1])%mod;

            // Remove duplicates
            if (hm.containsKey(ch)) {
                int lastOccur = hm.get(ch);
                dp[i] = (dp[i]-dp[lastOccur-1]+mod)%mod;
            }
            
            hm.put(ch,i); // Update last occurence of character
        }
        
        return dp[n]-1; // Ignore empty subsequence
    }
}