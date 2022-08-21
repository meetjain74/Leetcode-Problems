class Solution {
    public int integerReplacement(int n) {
        if (n==Integer.MAX_VALUE)
            return 32;
        
        // If n is even- 1 operation n/2
        // If n is odd- (n-1) or (n+1)
        // If n is odd i.e n=2k+1
        // n+1 = 2k+2 and n-1 = 2k
        // (n+1)/2 = k+1 and (n-1)/2=k
        // i.e (n+1)/2 and (n-1)/2 are consecutive and hence one is even and other odd
        // We move to the even side
        // Check one case for n=3
        
        int count = 0;
        while (n>1) {
            if (n%2==0) {
                n = n/2;
            }
            else {
                if (n!=3 && (n+1)%4==0)
                    n++;
                else
                    n--;
            }
            count++;
        }
        
        return count;
    }
}