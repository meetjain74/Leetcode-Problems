class Solution {
    public double myPow(double x, int n) {
        double ans = 1;
        if (n<0) {
            x = 1.0/x;
            n = -n;
        }
        
        
        while (n!=0) {
            int last_bit = (n&1);
            ans *= last_bit==1 ? x : 1;
            x = x*x;
            n = n>>>1;
        }
        
        return ans;
    }
}