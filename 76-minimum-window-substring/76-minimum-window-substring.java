class Solution {
    public String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        int[] freqS = new int[256];
        int[] freqT = new int[256];

        for (int i=0;i<tLen;i++) {
            freqT[t.charAt(i)]++;
        }
        
        int start=0;
        int end=0;
        
        // Start and end indices of min substring containing chars of T
        int minSubStartIndex=0;
        int minSubEndIndex=Integer.MAX_VALUE;
        
        while (end<sLen) {
            freqS[s.charAt(end)]++;
            int cmp = compare(freqS,freqT);
            if (cmp<0) {
                end++;
            }
            else if (cmp>=0) {
                while (start<=end && cmp>=0) {
                    freqS[s.charAt(start)]--;
                    cmp = compare(freqS,freqT);
                    if (end-start < minSubEndIndex-minSubStartIndex) {
                        minSubStartIndex=start;
                        minSubEndIndex=end;
                    }
                    start++;
                }                
                end++;
            }
        }
        
        return 
            minSubEndIndex==Integer.MAX_VALUE ? 
                            "" : s.substring(minSubStartIndex,minSubEndIndex+1);
    }
    
    // Returns 1 if S contains extra characters of chars present in T
    // Returns -1 if S contains less characters of chars present in T
    private int compare(int[] freqS,int[] freqT) {
        for (int i=0;i<256;i++) {
            if (freqT[i]!=0 && freqS[i]<freqT[i])
                return -1;
        }
        
        return 1;
    }
}