class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int max = 0;
        
        // Sliding window approach
        int start = 0;
        int count = 0; // Int zeroes count
        for (int end=0;end<n;end++) {
            count = count + (nums[end]==0?1:0);
            if (count==k+1) {
                while (nums[start]!=0) {
                    start++;
                }
                count--;
                start++;
            }
            max = Math.max(max,end-start+1);
        }
        
        return max;
    }
}