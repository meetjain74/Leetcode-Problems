class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        
        // dp[i][j] stores the count of distinct subsequences of 
        // string1 upto length i which equals string2 upto length j
        int dp[][] = new int [m+1][n+1];
        for (int i=0;i<=m;i++) {
            Arrays.fill(dp[i],-1);
        }
        return count(s,t,1,1,m,n,dp);
    }
    
    private int count(String s,String t,int slen,int tlen,int m,int n,int[][] dp) {
        if (tlen>n)
            return 1;
        if (slen>m)
            return 0;
        
        if (dp[slen][tlen]!=-1)
            return dp[slen][tlen];
        
        if (s.charAt(slen-1)==t.charAt(tlen-1)) {
            return dp[slen][tlen]=count(s,t,slen+1,tlen+1,m,n,dp)+
                                    count(s,t,slen+1,tlen,m,n,dp);
        }
        else {
            return dp[slen][tlen]=count(s,t,slen+1,tlen,m,n,dp);
        }
    }
}