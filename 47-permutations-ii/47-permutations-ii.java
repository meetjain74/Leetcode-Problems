class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> permutations = new HashSet<>();
        permute(permutations,nums,0);
        return new ArrayList<List<Integer>>(permutations);
    }
    
    public void permute(Set<List<Integer>>permutations, int[] nums,int i) {
        if (i==nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int j : nums)
                temp.add(j);
            permutations.add(temp);
            return;
        }
        
        for (int j=i;j<nums.length;j++) {
            // swap nums[i] and nums[j]
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            
            permute(permutations,nums,i+1);
            
            // Unswap(swap again) nums[i] and nums[j]
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}