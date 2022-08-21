class Solution {
    public boolean validPalindrome(String s) {
        return isPalindrome(s,0,s.length()-1,false);
    }
    
    private boolean isPalindrome(String s,int i,int j,boolean delete) {
        if (i>=j)
            return true;
        
        if (s.charAt(i)==s.charAt(j))
            return isPalindrome(s,i+1,j-1,delete);
        
        if (!delete) // Not deleted any character yet
            return isPalindrome(s,i+1,j,true) || isPalindrome(s,i,j-1,true);
        
        return false;
    }
}