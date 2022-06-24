class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans,k,n,1,new ArrayList<>());
        return ans;
    }
    
    private void helper(List<List<Integer>> ans,int k,int target,
                       int start,List<Integer> temp) {
        if (k==0 && target==0) {
            ans.add(temp);
            return;
        }
        
        if (k==0 || target==0) {
            return;
        }
        
        for (int i=start;i<=9;i++) {
            if (target-i>=0) {
                temp.add(i);
                helper(ans,k-1,target-i,i+1,new ArrayList<>(temp));
                temp.remove(temp.size()-1);
            }
        }
    }
}