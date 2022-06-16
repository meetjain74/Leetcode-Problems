class Solution {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        
        int n=s.length();
        int start=0;
        int end=n-1;
        while (start<=end) {
            if (!Character.isLetterOrDigit(s.charAt(start)))
                start++;
            else if (!Character.isLetterOrDigit(s.charAt(end)))
                end--;
            
            else if (s.charAt(start)!=s.charAt(end))
                return false;
            else {
                start++;
                end--;
            }
        }
        
        return true;
    }
}