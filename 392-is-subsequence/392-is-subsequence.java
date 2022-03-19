class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int slen = s.length();
        int tlen = t.length();
        for (int j=0;j<tlen;j++) {
            if (i==slen) return true;
            if (s.charAt(i)==t.charAt(j)) {
                i++;
            }
        }
        return i==slen;
    }
}