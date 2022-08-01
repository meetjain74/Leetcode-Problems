class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // Map stores value and its last index
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for (int i=0;i<nums.length;i++) {
            if (map.containsKey(nums[i])) {
                int index = map.get(nums[i]);
                if (i-index<=k) {
                    return true;
                }
            }
            map.put(nums[i],i);
        }
        
        return false;
    }
}