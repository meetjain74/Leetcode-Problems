class Solution {
    public int findDuplicate(int[] nums) {
        boolean[] arr = new boolean[nums.length];
		for (int i=0,size=nums.length;i<size;i++) {
			if (arr[nums[i]]) {
				return nums[i];
			}
			arr[nums[i]] = true;
		}
		return -1;
    }
}