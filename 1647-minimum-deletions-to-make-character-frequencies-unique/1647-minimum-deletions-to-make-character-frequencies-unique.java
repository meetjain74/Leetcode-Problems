class Solution {
    public int minDeletions(String s) {
        int freq[] = new int[26];
        for (char ch: s.toCharArray()) {
            freq[ch-'a']++;
        }
        
        int ans=0;
        TreeSet<Integer> set = new TreeSet<>(); // Store different frequencies
        for (int i=0;i<26;i++) {
            if (freq[i]==0)
                continue;
            
            if (!set.add(freq[i])) {
                while (freq[i]!=0 && !set.add(freq[i])) {
                    freq[i]--;
                    ans++;
                }
            }
        }
        
        return ans;
    }
}