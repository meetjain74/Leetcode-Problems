class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int maxLen = 1;
        int start = 0;
        int min = nums[0];
        int max = nums[0];
        PriorityQueue<Integer> minpq = new PriorityQueue<>();
        PriorityQueue<Integer> maxpq = 
            new PriorityQueue<>(Collections.reverseOrder());
        minpq.add(min);
        maxpq.add(max);
        
        for (int end=1;end<nums.length;end++) {
            min = Math.min(min,nums[end]);
            max = Math.max(max,nums[end]);
            minpq.add(nums[end]);
            maxpq.add(nums[end]);
            
            if (max-min<=limit) {
                maxLen = Math.max(maxLen,end-start+1);
                continue;
            }
            else {
                // Reduce window size
                while (start<=end && max-min>limit) {
                    minpq.remove(nums[start]);
                    maxpq.remove(nums[start]);
                    if (nums[start]==min) {
                        min = minpq.peek();
                    }
                    if (nums[start]==max) {
                        max = maxpq.peek();
                    }
                    start++;
                }
            }
        }
        
        return maxLen;
    }
}