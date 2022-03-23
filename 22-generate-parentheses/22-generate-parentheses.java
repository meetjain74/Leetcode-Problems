class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(n,0,0,0,"",ans);
        return ans;
    }
    
    public void helper(int n,int i, int open,int close,String str,List<String> ans) {
        if (i==2*n) {
            ans.add(str);
            return;
        }
        
        if (open<n) {
            helper(n,i+1,open+1,close,str+"(",ans);
        }
        
        if (close<open) {
            helper(n,i+1,open,close+1,str+")",ans);
        }
    }
}