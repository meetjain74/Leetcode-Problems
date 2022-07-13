class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        HashMap<String,Integer> dp = new HashMap<>(); // Store ans for words
        for (String word: words) {
            if (dp.containsKey(word)) {
                count += dp.get(word);
                continue;
            }
            
            boolean isSubseq = isSubsequence(word,s);
            dp.put(word,isSubseq?1:0);
            if (isSubseq) {
                count++;
            }
        }
        
        return count;
    }
    
    // Determine if s is subsequence of t
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int slen = s.length();
        int tlen = t.length();
        for (int j=0;j<tlen;j++) {
            if (i==slen) 
                return true;
            if (s.charAt(i)==t.charAt(j)) {
                i++;
            }
        }
        return i==slen;
    }
}