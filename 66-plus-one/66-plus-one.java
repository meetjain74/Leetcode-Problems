class Solution {
    public int[] plusOne(int[] digits) {
        int ans[] = new int[digits.length];
        int carry = 1;
        for (int i=digits.length-1;i>=0;i--) {
            if (digits[i]!=9 && carry==1) {
                ans[i]=digits[i]+carry;
                carry=0;
            }
            else if (carry==0) {
                ans[i]=digits[i];
            }
            else {
                ans[i]=0;
            }
        }
        
        if (carry==1) {
            ans = new int[digits.length+1];
            ans[0]=1;
        }
        
        return ans;
    }
}