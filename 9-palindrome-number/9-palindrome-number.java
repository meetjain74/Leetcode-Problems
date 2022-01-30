class Solution {
    public boolean isPalindrome(int x) {
        int y=reverse(x);
        if (x>=0 && x==y)
            return true;
        return false;
    }
    
    private int reverse(int x)
    {
        int reverse=0;
        int rem;
        
        while (x!=0)
        {
            rem=x%10;
            x=x/10;
            reverse=reverse*10+rem;
        }
        return reverse;
    }
}