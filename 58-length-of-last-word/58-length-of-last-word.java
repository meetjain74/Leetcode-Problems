class Solution {
    public int lengthOfLastWord(String s) {
        String[] token = s.split(" ");
        return token[token.length-1].length();
    }
}