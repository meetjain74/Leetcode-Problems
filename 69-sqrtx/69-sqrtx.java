class Solution {
    public int mySqrt(int x) {
        if (x==0) 
            return 0;
        
        // Binary search
        int low=0,high=x;
        while (low<=high) {
            long mid = low + (high-low)/2;
            if (mid*mid==x)
                return (int)mid;
            else if (mid*mid>x)
                high=(int)mid-1;
            else
                low=(int)mid+1;
        }
        return high;
    }
}