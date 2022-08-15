class Solution {
    public int longestIdealString(String s, int k) {
        int dp[][] = new int[27][s.length()];
        for (int i=0;i<27;i++) {
            Arrays.fill(dp[i],-1);
        }
        return solve(s,0,'#',k,dp);
    }
    
    private int solve(String s,int index,char prev,int k,int[][] dp) {
        if (index==s.length())
            return 0;
        
        int idx = prev=='#' ? 0 : prev-'a'+1;
        
        if (dp[idx][index]!=-1)
            return dp[idx][index];
        
        char ch = s.charAt(index);
        int s1 = 0;
        if (prev=='#' || Math.abs(ch-prev)<=k) {
            s1 = 1+solve(s,index+1,ch,k,dp);
        }
        
        int s2 = solve(s,index+1,prev,k,dp);
        
        return dp[idx][index]=Math.max(s1,s2);
    }
}
