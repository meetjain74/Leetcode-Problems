class Solution {
    public int countCharacters(String[] words, String chars) {
        int freq[] = new int[26];
        for (char ch: chars.toCharArray()) {
            freq[ch-'a']++;
        }
        
        int ans = 0;
        for (String word: words) {
            // Freq of word
            int f[] = new int[26];
            for (char ch: word.toCharArray()) {
                f[ch-'a']++;
            }
            
            boolean good = true; // is good string
            for (int i=0;i<26;i++) {
                if (freq[i]<f[i]) {
                    good=false;
                    break;
                }
            }
            
            if (good) {
                ans+=word.length();
            }
        }
        
        return ans;
    }
}