class Solution {
    public boolean judgeSquareSum(int c) {
        long a = 0;
        while (a*a<=c) {
            int b = c - (int)(a*a);
            if (isPerfectSquare(b))
                return true;
            a++;
        }
        return false;
    }
    
    private boolean isPerfectSquare(int n) {
        int low=0,high=n;
        while (low<=high) {
            long mid = low + (high-low)/2;
            if (mid*mid==n)
                return true;
            else if (mid*mid>n)
                high=(int)mid-1;
            else
                low=(int)mid+1;
        }
        return false;
    }
}