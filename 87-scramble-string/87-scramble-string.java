class Solution {
    // Map to store result of scrambled strings
    HashMap<String,Boolean> map = new HashMap<>(); 
    public boolean isScramble(String s1, String s2) {
        return solve(s1,s2);
    }
    
    private boolean solve(String s1,String s2) {
        if (s1.equals(s2))
            return true;
        
        if (s1.length()<=1)
            return false;

        String key = s1+" "+s2;
        if (map.containsKey(key))
           return map.get(key);
        
        int n = s1.length();
        boolean isScramble = false;
        for (int i=1;i<n;i++) {
            
            // Two parts of string s1 - p1:[0,i) and p2:[i,n-1]
            // Return true if case 1 OR case 2 is true
            
            // Case 1: Do not swap parts p1 and p2
            // Check if respective parts in s1 and s2 are scrambled
            
            boolean notSwapLeft = isScramble(s1.substring(0,i),s2.substring(0,i));
            boolean notSwapRight = false;
            if (notSwapLeft) {
                // Only solve this if notSwapLeft is true
                notSwapRight = isScramble(s1.substring(i),s2.substring(i));
            }
            if (notSwapLeft && notSwapRight) {
                isScramble = true;
                break;
            }
            
            // Case 2: Swap parts p1 and p2
            // Check if respective parts in s1 and s2 are scrambled
            
            boolean swapLeft = isScramble(s1.substring(0,i),s2.substring(n-i));
            if (!swapLeft) continue;
            boolean swapRight = isScramble(s1.substring(i),s2.substring(0,n-i));
            if (swapLeft && swapRight) {
                isScramble = true;
                break;
            }
        }
        
        map.put(key,isScramble);
        return isScramble;
    }
}