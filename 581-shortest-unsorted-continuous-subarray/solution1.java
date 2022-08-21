class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] copy = nums.clone();
        Arrays.sort(copy);
        
        int start = -1;
        int end = -1;
        for (int i=0;i<nums.length;i++) {
            if (nums[i]==copy[i])
                continue;
            else if (start==-1) {
                start=i;
                end=i;
            }
            end = i;
        }
        
        if (start==-1)
            return 0;
        
        return end-start+1;
    }
}
