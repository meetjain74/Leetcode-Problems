class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        permute(permutations,nums,0);
        return permutations;
    }
    
    public void permute(List<List<Integer>>permutations, int[] nums,int i) {
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
            
            // Unswap nums[i] and nums[j]
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}