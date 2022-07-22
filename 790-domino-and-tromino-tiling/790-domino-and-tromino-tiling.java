/*
number of ways to tile 2*i board i.e dp[i]

Consider dp[i-1]- One way to arrange domino vertically for remaining

Consider dp[i-2]- One way to arrange two dominos horizontally for remaining
For above two vertical dominos case already considered in dp[i-1]

Consider dp[i-3]- Tiling using domino already considered in dp[i-1] and dp[i-2]
Using tromino to tile 2*3 block - 2 ways ( └ ┐ & ┌ ┘)  
Hence 2*dp[i-3]

Consider dp[i-4]- Tiling using domino already considered 
Tiling using tromino like this (└ ┐| & |┌ ┘) also considered
Tiling using tromino like this- (└ - ┐ & ┌ - ┘) not considered
Hence 2*dp[i-4]

and so on

dp[i] = dp[i-1] + dp[i-2] + 2*(dp[i-3]+dp[i-4]+......+dp[0])
*/

class Solution {
    int mod = 1000000007;
    public int numTilings(int n) {
        if (n==1) return 1;
        if (n==2) return 2;
        
        // dp[i] represents number of ways to tile 2*i board
        int dp[] = new int[n+1];
        dp[1]=1;
        dp[2]=2;
        dp[3]=5; // 11 24 53 117 258 569 1255 2768 6105 13465 29698 65501
        for (int i=4;i<=n;i++) {
            // dp[i] = dp[i-1] + dp[i-2] + 2*(dp[i-3]+dp[i-4]+......+dp[0])
            // dp[i-1] = dp[i-2] + dp[i-3] + 2*(dp[i-4]+.......+dp[0])
            // dp[i]-dp[i-1] = dp[i-1]+dp[i-3]
            // dp[i] = 2*dp[i-1]+dp[i-3]
            dp[i] = ((2*dp[i-1])%mod + dp[i-3])%mod;
        }
        
        return dp[n];
    }
}