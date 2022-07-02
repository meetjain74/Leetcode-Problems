class Solution {
    public String toLowerCase(String s) {
        String ans = "";
        for (char ch: s.toCharArray()) {
            if (Character.isUpperCase(ch)) 
                ans += (char)(ch+32);
            else
                ans += ch;
        }
        return ans;
    }
}