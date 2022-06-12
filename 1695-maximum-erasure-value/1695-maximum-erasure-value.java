class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        // Map to store number and its last index in array
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        int start=0;
        int score=0;
        int runningSum=0;
        for (int end=0,size=nums.length;end<size;end++) {
            runningSum += nums[end];
            if (hm.get(nums[end])!=null) {
                int lastIndex = hm.get(nums[end]);
                while (start<=lastIndex) {
                    runningSum -= nums[start];
                    start++;
                }
            }
            hm.put(nums[end],end);
            score = Math.max(score,runningSum);
        }
        
        return score;
    }
}