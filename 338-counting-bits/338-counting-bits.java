class Solution {
    public int[] countBits(int n) {
        // dp[i] represents the number of set bits in i
        int dp[] = new int[n+1];
        
        for (int i=1;i<=n;i++) {
            dp[i] = ((i%2==0) ? 0 : 1) + dp[i/2];
        }
        
        return dp;
    }
}

/* 
Explanation of the logic -
15 -> 1111 
lastBit -> 1 for odd numbers and 0 for even numbers 
Exclude last bit -> Number becomes 15/2

i.e
countSetBits[n] = lastBit(1 if set, 0 if unset) + countBits[n/2]

*/
