class Solution {
    public int integerReplacement(int n) {
        return steps(n);
    }
    
    public int steps(int n) {
        if (n==1)
            return 0;
        
        if (n%2==0)
            return 1+steps(n/2);
        
        if (n!=Integer.MAX_VALUE)
            return 1+Math.min(steps(n-1),steps(n+1));
        else
            return Math.min(1+steps(n-1),2+steps(n/2+1));
    }
}