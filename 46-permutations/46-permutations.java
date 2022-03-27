class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        permute(permutations, new ArrayList<Integer>(), nums, 0);
        return permutations;
    }
    
    public void permute(List<List<Integer>> permutations, List<Integer> selected, 
                           int[] nums, int pos) {
        if(pos == nums.length) {
            permutations.add(new ArrayList<Integer>(selected));
            return;
        }
        
        // Iterating over all elements in the array
        for(int i=0;i<nums.length;i++) {
            // If element already selected, continue loop
            if(selected.contains(nums[i])) 
                continue;
            
            selected.add(nums[i]);
            permute(permutations, selected, nums, pos+1);
            selected.remove(selected.size()-1); //Remove latest element added
        }
    }
}