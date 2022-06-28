class Solution {
    public int minFlips(String s) {
        int n = s.length();
        
        // Make string repeat at end
        s=s+s;
        
        // There are two possible strings s can be converted to
        // Alternate 0 and 1 starting with 0 i.e 010101.....
        // Alternate 1 and 0 starting with 1 i.e 101010.....
        
        // Create these two strings
        char[] alt1 = new char[2*n];
        char[] alt2 = new char[2*n];
        
        for (int i=0;i<2*n;i++) {
            alt1[i] = (i%2==0) ? '0' : '1';
            alt2[i] = (i%2==0) ? '1' : '0'; 
        }
        
        // For length n find the minimum difference of string s with alt1 or alt2
        int first = 0; // difference of s with alt1
        int second = 0; // difference of s with alt2
        
        int ans = Integer.MAX_VALUE;
        
        // Consider every sliding window of length n in s
        int start = 0;
        for (int end=0;end<2*n;end++) {
            if (s.charAt(end)!=alt1[end]) {
                first++;
            }
            if (s.charAt(end)!=alt2[end]) {
                second++;
            }
            
            if (end-start+1==n) {
                ans = Math.min(ans,Math.min(first,second));
                if (s.charAt(start)!=alt1[start]) {
                    first--;
                }
                if (s.charAt(start)!=alt2[start]) {
                    second--;
                }
                
                start++;    
            }
        }
        
        return ans;
    }
}
