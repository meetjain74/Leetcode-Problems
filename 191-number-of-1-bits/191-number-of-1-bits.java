public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ans = 0;
        // Integer type in Java is signed and there is no unsigned int. \
        // So the input 2147483648 is represented in Java as -2147483648 (in java int type has a         // cyclic representation, that means Integer.MAX_VALUE+1==Integer.MIN_VALUE).
        // This force us to use n!=0 in the while condition and we cannot use n>0
        while (n!=0) {
            n = n&(n-1); // Removes the last set bit 
            ans++;
        }
        return ans;
    }
}