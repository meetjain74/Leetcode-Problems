class Solution {
    public int tribonacci(int n) {
        int dp[] = new int[n+1];
        
        for (int i=0;i<=n;i++) {
            if (i==0) 
                dp[i]=0;
            else if (i==1 || i==2)
                dp[i]=1;
            else
                dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
        }
        
        return dp[n];
    }
}