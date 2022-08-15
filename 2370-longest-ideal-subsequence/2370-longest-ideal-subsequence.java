class Solution {
    public int longestIdealString(String s, int k) {
        int n=s.length();
        int dp[]=new int[26];
        
        for(int i=0;i<n;i++) {
            int curr=s.charAt(i)-'a';
            int temp=dp[curr];
            for(int c=0;c<26;c++) {
                if(Math.abs(c-curr)<=k) {
                    temp=Math.max(temp,dp[c]+1);
                }
            }
            dp[curr]=temp;
        }
        
        int max=0;
        for (int i=0;i<26;i++) {
            max = Math.max(max,dp[i]);
        }
        
        return max;
    }
}