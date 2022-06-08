class Solution {
    public int removePalindromeSub(String s) {
        return isPalindrome(s) ? 1 : 2;
    }
    
    public boolean isPalindrome(String s) {
        int n = s.length();
        for (int i=0;i<n/2;i++) {
            if ((s.charAt(i))!=s.charAt(n-i-1))
                return false;
        }
        return true;
    }
}

/*

Explanation - 

If given string is palindrome, directly remove that string and 1 is answer

Else remove all a and then all b 
{subsequence of a is a palindrome as well as subsequence of b is a palindrome}
Hence, 2 is the answer

*/

