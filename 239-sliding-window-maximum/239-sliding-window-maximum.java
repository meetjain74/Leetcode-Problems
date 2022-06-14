class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int start=0;
        int end=0;
        
        Deque<Integer> values=new ArrayDeque<>();
        int[] ans = new int[n-k+1];
        while (end<n) {
            // Add element to queue accordingly
            
            // If current element greater than values.peek() remove all of them
            while (values.size()!=0 && values.peekLast()<nums[end]) {
                values.pollLast();
            }
            values.addLast(nums[end]);
            
            if (end-start+1<k) {
                end++;
            }
            else if (end-start+1==k) {
                ans[start]=values.peekFirst();
                if (values.peekFirst()==nums[start])
                    values.pollFirst();
                start++;
                end++;
            }
        }

        return ans;
    }
}

