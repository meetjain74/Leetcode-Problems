class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        // Apply swap sort
        int i=0,size=nums.length;
        while (i<size) {
            if (nums[i]!=nums[nums[i]-1]) {
                // swap nums[i] and nums[nums[i]-1]
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
            else {
                // Either nums[i]==i+1 - At correct position
                // Or nums[i]==nums[nums[i]-1] - Duplicate element
                i++;
            }
        }
        
        List<Integer> duplicates = new ArrayList<>();
        for (int j=0;j<size;j++) {
            if (nums[j]!=j+1)
                duplicates.add(nums[j]);
        }
        
        return duplicates;
    }
}
