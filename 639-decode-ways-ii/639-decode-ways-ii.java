class Solution {
    int mod = 1000000007;
    public int numDecodings(String s) {
        int n = s.length();
        
        // dp[i] represents number of encodings upto length i
        long dp[] = new long[n+1];
        dp[0] = 1;
        
        for (int i=1;i<=n;i++) {
            if (i==1) {
                char ch = s.charAt(i-1);
                if (ch=='0')
                    dp[i]=0;
                else if (ch=='*')
                    dp[i]=9;
                else
                    dp[i]=1;
            }
            else {
                char x = s.charAt(i-1);
                char y = s.charAt(i-2);
                
                if (y=='*' && x=='*')
                    dp[i] = dp[i-2]*15 + dp[i-1]*9;
                else if (y=='*') {
                    int xi = x-'0';
                    dp[i] = dp[i-2]*( 1 + ((xi<=6)?1:0) ) +
                            dp[i-1]*( (xi==0)?0:1 );
                            
                }
                else if (x=='*') {
                    int yi = y-'0';
                    dp[i] = dp[i-2]*( ((yi==1)?9:0) + ((yi==2)?6:0) ) + 
                            dp[i-1]*( 9 );
                }
                else {
                    int xi = x-'0';
                    int yi = y-'0';
                    int num = yi*10+xi;
                    
                    if (num>26 || yi==0 || num==0) 
                        dp[i] = dp[i-1]*( (xi==0)?0:1 );
                    else
                        dp[i] = dp[i-1]*( (xi==0)?0:1 ) + dp[i-2];
                }   
            }
            
            dp[i] = dp[i]%mod;
        }
        
        return (int)dp[n];
    }
}