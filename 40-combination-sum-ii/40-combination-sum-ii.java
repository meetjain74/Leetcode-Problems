class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
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
            if (i!=index && candidates[i]==candidates[i-1])
                continue;
            if (target-candidates[i]>=0) {
                temp.add(candidates[i]);
                combinationSum(ans,candidates,
                               target-candidates[i],i+1,new ArrayList<>(temp));
                temp.remove(temp.size()-1);
            }
        }
    }
}