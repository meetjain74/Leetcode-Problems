class Solution {
    public int divide(int dividend, int divisor) {
        int quotient=0;
        int sign = (dividend>=0) == (divisor>=0) ? 1:-1;
        
        if (dividend==Integer.MIN_VALUE && divisor==-1)
            return Integer.MAX_VALUE;
        
        dividend=Math.abs(dividend);
        divisor=Math.abs(divisor);
        
        while (dividend-divisor>=0) {
            int count=0;
            while (dividend - (divisor<<1<<count) >= 0) {
                count++;
            }
            quotient += 1<<count;
            dividend -= divisor<<count;
        }
        
        return sign*quotient;
    }
}
