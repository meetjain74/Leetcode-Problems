class Solution {
    public int minSteps(int n) {
        if (n==1)
            return 0;
        return 2+helper(n,2,1); //2 A + already copy of 1
    }
    
    private int helper(int n,int curr,int copy) {
        if (curr==n)
            return 0;
        
        if (curr>n)
            return Integer.MAX_VALUE;
        
        // Copy all and paste - 2 steps
        int h1 = helper(n,curr+curr,curr);
        
        // Paste current copy - 1 step
        int h2 = helper(n,curr+copy,copy);
        
        if (h1==Integer.MAX_VALUE && h2==Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        
        if (h1==Integer.MAX_VALUE)
            return 1+h2;
        
        else if (h2==Integer.MAX_VALUE)
            return 2+h1;
        
        return Math.min(2+h1,1+h2);
    }
}