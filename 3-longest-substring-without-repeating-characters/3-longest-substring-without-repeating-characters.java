class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> hm = new HashMap<Character,Integer>();
        // Map stores character key and its last index position 
        
        // Only need to know the left and right indexes of the substring
        int left=0,right=0;
        int maxSize=0;
        
        for (int i=0;i<s.length();i++)
        {
            Character ch=s.charAt(i);
            if (hm.containsKey(ch))
                left=Math.max(left,hm.get(ch)+1); 
            // Left Cannot Go Back once move  forward
            
            maxSize = Math.max(maxSize,right-left+1);
            right++;
            hm.put(ch,i); // Add current index to map
        }
        
        return maxSize;
    }
}
