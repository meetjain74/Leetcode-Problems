class Solution {
    public int longestPalindrome(String s) {
        int freq[] = new int[52];
        for (char ch : s.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                freq[ch-'A']++;
            }
            else {
                freq[26+ch-'a']++;
            }
        }
        
        int ans = 0;
        boolean containsOdd = false;
        
        for (int i=0;i<52;i++) {
            if (freq[i]%2==0) {
                // Even
                ans = ans + freq[i];
            }
            else {
                ans = ans + freq[i] - 1;
                containsOdd=true;
            }
        }
        
        ans = ans + (containsOdd ? 1 : 0);
        return ans;
    }
}