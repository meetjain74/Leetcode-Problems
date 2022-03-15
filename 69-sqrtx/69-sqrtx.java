class Solution {
    public int mySqrt(int x) {
        if (x==0) return 0;
        
        // Binary search
        long low=0,high=x;
        long mid=0;
        while (low<=high) {
            mid = (low+high)/2;
            System.out.println(low+" "+high+" : "+mid);
            if (mid*mid==x)
                return (int)mid;
            else if (mid*mid>x)
                high=mid-1;
            else
                low=mid+1;
        }
        return (int)high;
    }
}