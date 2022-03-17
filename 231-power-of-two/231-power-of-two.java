class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n<=0) return false;
        int val = 1;
        while (true) {
            if (val==n) 
                return true;
            
            if (val>n || val==Integer.MIN_VALUE)
                return false;
            
            val = val*2;
        }
    }
}