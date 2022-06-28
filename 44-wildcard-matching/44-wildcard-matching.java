class Solution {
    public boolean isMatch(String s, String p) {
        int dp[][] = new int[s.length()+1][p.length()+1];
        for (int i=0;i<s.length();i++) {
            Arrays.fill(dp[i],-1);
        }
        return helper(dp,s,p,0,0);
    }
    
    // currS and currP are current indexes on s and p
    private boolean helper(int dp[][],String s,String p,int currS,int currP) {
        if (currS==s.length() && currP==p.length())
            return true;
        
        if (currP==p.length())
            return false;
        
        if (p.charAt(currP)=='*' && currS==s.length()) {
            return helper(dp,s,p,currS,currP+1);
        }
        
        if (currS==s.length()) 
            return false;
        
        if (dp[currS][currP]!=-1) {
            return dp[currS][currP]==1;
        }
        
        if (s.charAt(currS)==p.charAt(currP) || p.charAt(currP)=='?') {
            dp[currS][currP] = helper(dp,s,p,currS+1,currP+1) ? 1 : 0;
            return dp[currS][currP]==1;
        }
        
        if (p.charAt(currP)=='*') {
            if (currP+1==p.length())
                return true;
            
            if (p.charAt(currP+1)=='*') {
                dp[currS][currP] = helper(dp,s,p,currS,currP+1) ? 1 : 0;
                return dp[currS][currP]==1; 
            }
                
            
            dp[currS][currP] = 
                (helper(dp,s,p,currS+1,currP) || helper(dp,s,p,currS,currP+1)) ? 1 : 0;
            return dp[currS][currP]==1;
            // char ch = p.charAt(currP+1);
            // for (int i=currS;i<s.length();i++) {
            //     if ((ch=='?' || s.charAt(i)==ch) && helper(s,p,i,currP+1)) {
            //         return true;
            //     }
            // }
        }
        
        return false;
    }
}