class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int maxLen = 1;
        int start = 0;
        int min = nums[0];
        int max = nums[0];
        Deque<Integer> mindq = new ArrayDeque<>();
        Deque<Integer> maxdq = new ArrayDeque<>();
        mindq.add(min);
        maxdq.add(max);
        
        for (int end=1;end<nums.length;end++) {
            min = Math.min(min,nums[end]);
            max = Math.max(max,nums[end]);
            
            // Remove values less than min in mindq
            while (mindq.size()!=0 && mindq.peekLast()>nums[end]) {
                mindq.pollLast();
            }
            mindq.add(nums[end]);
            
            // Remove values greater than max in maxdq
            while (maxdq.size()!=0 && maxdq.peekLast()<nums[end]) {
                maxdq.pollLast();
            }
            maxdq.add(nums[end]);
            
            if (max-min<=limit) {
                maxLen = Math.max(maxLen,end-start+1);
                continue;
            }
            else {
                // Reduce window size
                while (start<=end && max-min>limit) {
                    if (nums[start]==min) {
                        min = mindq.pollFirst();
                        min = mindq.peekFirst();
                    }
                    if (nums[start]==max) {
                        max = maxdq.pollFirst();
                        max = maxdq.peekFirst();
                    }
                    start++;
                }
            }
        }
        
        return maxLen;
    }
}