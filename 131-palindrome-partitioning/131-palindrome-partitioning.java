class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        helper(ans,s,0,new ArrayList<>());
        return ans;
    }
    
    private void helper(List<List<String>> ans,String s,
                        int index,List<String> temp) {
        if (index==s.length()) {
            ans.add(temp);
            return;
        }
        
        String x = "";
        for (int i=index;i<s.length();i++) {
            x = x+s.charAt(i);
            if (isPalindrome(x)) {
                temp.add(x);
                helper(ans,s,i+1,new ArrayList<>(temp));
                temp.remove(temp.size()-1);
            }
        }
    }
    
    private boolean isPalindrome(String word) {
        int length=word.length();
        for(int i=0;i<length/2;i++) {
            if (word.charAt(i)!=word.charAt(length-i-1))
                return false;
        }
        return true;
    }
}