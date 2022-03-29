class Solution {
    public String generateTheString(int n) {
        String ans = "";
        int i=0;
        if (n%2==0) {
            ans+="a";
            i=1;
        }
        
        while (i<n) {
            ans+="b";
            i++;
        }
        
        return ans;
    }
}