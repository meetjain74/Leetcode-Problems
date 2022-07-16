class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans,nums,0,-1,new ArrayList<>());
        return ans;
    }
    
    private void helper(List<List<Integer>> ans,int[] nums,int index,int prevIndex
                       ,List<Integer> temp) {
        if (index==nums.length) {
            if (temp.size()>=2)
                ans.add(new ArrayList<>(temp));
            return;
        }
        
        // Take current element if possible
        if (prevIndex==-1 || nums[index]>=nums[prevIndex]) {
            temp.add(nums[index]);
            helper(ans,nums,index+1,index,temp);
            temp.remove(temp.size()-1);
        }
        
        if (prevIndex!=-1 && nums[index]==nums[prevIndex])
            return;
        
        // Not take current element
        helper(ans,nums,index+1,prevIndex,temp);
    }
}