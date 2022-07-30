class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> universal = new ArrayList<>();
        
        // Reduce words2 to single freq word
        int freq[] = new int[26];
        
        for (String word: words2) {
            int f[] = new int[26];
            for (char ch: word.toCharArray()) {
                f[ch-'a']++;
            }
            
            for (int i=0;i<26;i++) {
                freq[i] = Math.max(freq[i],f[i]);
            }
        }
        
        // Check if that word is subset of words in word1 or not
        outer:for (String word: words1) {
            int f[] = new int[26];
            for (char ch: word.toCharArray()) {
                f[ch-'a']++;
            }
            
            for (int i=0;i<26;i++) {
                if (freq[i]>f[i])
                    continue outer;
            }
            
            universal.add(word);
        }
        
        return universal;
    }
}