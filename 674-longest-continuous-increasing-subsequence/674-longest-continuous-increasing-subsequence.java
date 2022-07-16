class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int n=nums.length;
        int i=1;
        int LCIS=1;
        
        int currlen=1;
        while (i<n) {
            if (nums[i]>nums[i-1]) {
                currlen++;
            }
            else {
                currlen=1;
            }
            LCIS=Math.max(LCIS,currlen);
            i++;
        }
        
        return LCIS;
    }
}