class Solution {
    public String[] keys = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length()!=0)
            helper(ans,digits,0,"");
        return ans;
    }
    
    //i is iterator for the string digits
    private void helper(List<String> ans,String digits,int i,String temp) {
        if (i==digits.length()) {
            ans.add(temp);
            return;
        }
        
        int digit = digits.charAt(i)-'0';
        String key = keys[digit];
        
        for (int go=0;go<key.length();go++) {
            helper(ans,digits,i+1,temp+Character.toString(key.charAt(go)));
        }
    }
}