class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        for (String word: words) {
            if (isMatch(word,pattern))
                ans.add(word);
        }
        
        return ans;
    }
    
    private boolean isMatch(String word,String pattern) {
        HashMap<Character,Character> map = new HashMap<>();
        HashSet<Character> used = new HashSet<>();
        int len = pattern.length();
        for (int i=0;i<len;i++) {
            char pch = pattern.charAt(i);
            char wch = word.charAt(i);
            if (!map.containsKey(pch)) {
                if (used.contains(wch))
                    return false;
                
                map.put(pch,wch);
                used.add(wch);
                continue;
            }
            
            if (map.get(pch)!=wch) {
                return false;
            }
        }
        
        return true;
    }
}