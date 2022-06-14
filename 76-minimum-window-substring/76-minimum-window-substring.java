class Solution {
    public String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        
        HashMap<Character,Integer> freq = new HashMap<>();

        for (int i=0;i<tLen;i++) {
            char ch = t.charAt(i);
            freq.put(ch, freq.containsKey(ch) ? freq.get(ch)+1 : 1);
        }
        
        int start=0;
        int end=0;
        
        String ans = "";
        int minLen=Integer.MAX_VALUE;
        
        int count = freq.size();
        
        while (end<sLen) {
            char che = s.charAt(end);
            if(freq.containsKey(che)) {
				freq.put(che,freq.get(che)-1);
				if(freq.get(che)==0) {
					count--; 
                }		
			}
            
            if (count==0) {
                if (end-start+1<minLen) {
                    ans = s.substring(start,end+1);
                    minLen=end-start+1;
                }
                
                while (start<=end && count==0) {
                    char chs = s.charAt(start);
                    if(freq.containsKey(chs)) {
                        if (freq.get(chs)==0)
                            count++;
                        freq.put(chs,freq.get(chs)+1);
                    }
                    start++;
                    if (count==0 && end-start+1<minLen) {
                        ans = s.substring(start,end+1);
                        minLen=end-start+1;
                    }
                }
            }
            
            end++;
        }
        
        return ans;
    }
}