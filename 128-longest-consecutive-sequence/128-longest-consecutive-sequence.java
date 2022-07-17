class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num: nums) {
            set.add(num);
        }
        
        int maxLen = 0;
        for (int num: nums) {
            if (!set.contains(num-1)) {
                int currentlen = 1;
                
                int current = num;
                while (set.contains(current+1)) {
                    currentlen++;
                    current=current+1;
                }
                
                maxLen = Math.max(maxLen,currentlen);
            }
        }
        
        return maxLen;
    }
}