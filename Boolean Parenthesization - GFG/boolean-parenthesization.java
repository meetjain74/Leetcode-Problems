class Solution{
    static int countWays(int N, String S){
        // dp[i][j][0] represents count of ways for expression [i,j] for true
        // and dp[i][j][1] for false
        int dp[][][] = new int[N][N][2];
        for (int i=0;i<N;i++) {
            for (int j=0;j<N;j++) {
                Arrays.fill(dp[i][j],-1);
            }
        }
        return solve(S,0,N-1,true,dp);
    }
    
    // eval represents to what we need to evaluate the expression to
    private static int solve(String s,int i,int j,boolean eval,int[][][] dp) {
        if (i>j)
            return 0;
            
        if (i==j) {
            if (eval==true) // Evaluate expression to true
                return s.charAt(i)=='T' ? 1:0;
            else // Evaluate expression to false
                return s.charAt(i)=='F' ? 1:0;
        }
        
        if (dp[i][j][eval?1:0]!=-1)
            return dp[i][j][eval?1:0];
        
        long count = 0;
        
        for (int k=i+1;k<=j-1;k=k+2) {
            // Divide expression into two parts - (i,k-1) && (k+1,j)
            // And k is the operator &, | , ^
            
            int leftTrue = solve(s,i,k-1,true,dp);
            int leftFalse = solve(s,i,k-1,false,dp);
            int rightTrue = solve(s,k+1,j,true,dp);
            int rightFalse = solve(s,k+1,j,false,dp);
            
            char operator = s.charAt(k);
            
            if (operator=='&') {
                if (eval==true) {
                    count = count + leftTrue*rightTrue;
                }
                else {
                    count = count + leftTrue*rightFalse 
                            + leftFalse*rightTrue + leftFalse*rightFalse;
                }
            }
            
            else if (operator=='|') {
                if (eval==true) {
                    count = count + leftTrue*rightFalse 
                            + leftFalse*rightTrue + leftTrue*rightTrue;
                }
                else {
                    count = count + leftFalse*rightFalse;
                }
            }
            
            else { // operator - '^'
                if (eval==true) {
                    count = count + leftTrue*rightFalse 
                            + leftFalse*rightTrue;
                }
                else {
                    count = count + leftTrue*rightTrue 
                            + leftFalse*rightFalse;
                }
            }
        }
        
        return dp[i][j][eval?1:0] = (int)count%1003;
    }
}
