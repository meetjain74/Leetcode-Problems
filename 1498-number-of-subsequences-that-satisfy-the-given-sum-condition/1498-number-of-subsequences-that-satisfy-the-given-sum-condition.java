class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        
        int start = 0;
        int end = nums.length-1;
        int count = 0;
        int mod = 1000000007;
        
        int power[] = new int[nums.length]; // Store powers of 2
        power[0] = 1;
        for (int i=1;i<nums.length;i++) {
            power[i] = (power[i-1]*2)%mod;
        }
        
        while (start<=end) {
            if (nums[start]+nums[end]<=target) {
                count = (count+power[end-start])%mod;
                start++;
            }
            else {
                end--;
            }
        }
        
        return count;
    }
}
