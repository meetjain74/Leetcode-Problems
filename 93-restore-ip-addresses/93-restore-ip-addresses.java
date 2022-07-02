class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        
        if (s.length()>12)
            return ans;
        
        helper(ans,s,"",0,0);
        return ans;
    }
    
    private void helper(List<String> ans,String s,String temp,int dotCount,int index) {
        if (dotCount==5 || index==s.length()) {
            if (index==s.length() && dotCount==4) {
                ans.add(temp.substring(0,temp.length()-1));
            }
            return;
        }
        
        helper(ans,s,temp+s.charAt(index)+".",dotCount+1,index+1);
        if (index+1<s.length() && isValid(s.substring(index,index+2)))
            helper(ans,s,temp+s.substring(index,index+2)+".",dotCount+1,index+2);
        if (index+2<s.length() && isValid(s.substring(index,index+3)))
            helper(ans,s,temp+s.substring(index,index+3)+".",dotCount+1,index+3);
    }
    
    private boolean isValid(String ipNum) {
        if (ipNum.length()>1 && ipNum.charAt(0)=='0')
            return false;
        
        int num = Integer.parseInt(ipNum);
        if (num>255)
            return false;
        
        return true;
    }
}