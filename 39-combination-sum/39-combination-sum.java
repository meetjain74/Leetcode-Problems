class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        combinationSum(ans,candidates,target,0,new ArrayList<>());
        return ans;
    }
    
    private void combinationSum(List<List<Integer>> ans,int[] candidates,
                               int target,int index,List<Integer> temp) {
        if (target==0) {
            ans.add(temp);
            return;
        }
        
        for (int i=index;i<candidates.length;i++) {
            if (target-candidates[i]>=0) {
                temp.add(candidates[i]);
                combinationSum(ans,candidates,
                               target-candidates[i],i,new ArrayList<>(temp));
                temp.remove(temp.size()-1);
            }
        }
    }
}