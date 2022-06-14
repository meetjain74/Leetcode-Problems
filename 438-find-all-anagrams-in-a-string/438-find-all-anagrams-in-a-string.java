class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> indices = new ArrayList<>();
        findStartIndicesForAnagrams(indices,s,p);
        return indices;
    }
    
    private void findStartIndicesForAnagrams(List<Integer> indices,String s,String p) {
        int freqP[] = new int[26]; // Stores frequency for the string p
        int pLen = p.length();
        for (int i=0;i<pLen;i++) {
            freqP[p.charAt(i)-'a']++;
        }
        
        int freqS[] = new int[26]; // Stores frequency for the string s
        int sLen = s.length();
        
        // Sliding window approach
        int start=0;
        int end=0;
        while (end<sLen) {
            freqS[s.charAt(end)-'a']++;
            if (end-start+1<pLen) {
                end++;
            }
            else if (end-start+1==pLen) {
                if (isEqual(freqS,freqP))
                    indices.add(start);
                freqS[s.charAt(start)-'a']--;
                start++;
                end++;
            }
        }
    }
    
    private boolean isEqual(int freq1[], int freq2[]) {
        for (int i=0;i<26;i++) {
            if (freq1[i]!=freq2[i])
                return false;
        }
        return true;
    }
}