class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days[days.length-1];
        
        // dp[i] represents minimum cost upto day i
        int dp[] = new int[n+1];
        
        HashSet<Integer> set = new HashSet<>();
        for (int day: days) {
            set.add(day);
        }
        
        dp[0] = 0; // No cost
        for (int i=1;i<=n;i++) {
            if (!set.contains(i)) {
                // Same as previous day
                dp[i] = dp[i-1];
                continue;
            }
            
            int p1 = (i>=1) ? (dp[i-1] + costs[0]) : costs[0]; // Buying 1 day pass
            int p7 = (i>=7) ? (dp[i-7] + costs[1]) : costs[1]; // Buying 7 day pass
            int p30 = (i>=30) ? (dp[i-30] + costs[2]) : costs[2]; // Buying 30 day pass
            
            dp[i] = Math.min(p1,Math.min(p7,p30));
        }
        
        return dp[n];
    }
}