class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        HashMap<Integer,Integer> prefixSum = new HashMap<>();
        prefixSum.put(0,1); // Prefix sum 0 - subarray with no elements
        
        int sum = 0;
        for (int i=0;i<n;i++) {
            sum = sum+nums[i];
            if (prefixSum.containsKey(sum-k)) {
                count += prefixSum.get(sum-k);
            }
            prefixSum.put(sum,prefixSum.getOrDefault(sum,0) + 1);
        }
        
        return count;
    }
}