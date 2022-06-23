class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        getCombinations(ans,n,1,k,new ArrayList<>());
        return ans;
    }
    
    private void getCombinations(List<List<Integer>> ans,int n,
                                int index,int k,List<Integer> temp) {
        if (temp.size()==k) {
            ans.add(temp);
            return;
        }
        
        for (int i=index;i<=n;i++) {
            temp.add(i);
            getCombinations(ans,n,i+1,k,new ArrayList<>(temp));
            temp.remove(temp.size()-1);
        }
    }
}