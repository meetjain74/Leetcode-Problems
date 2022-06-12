class Solution {
    public int findDuplicate(int[] nums) {
        HashSet<Integer> values = new HashSet<>();
        for (int i=0,size=nums.length;i<size;i++) {
            if (values.contains(nums[i]))
                return nums[i];
            values.add(nums[i]);
        }
        return -1;
    }
}