/*
 1.     1
 2.     11
 3.     21
 4.     1211
 5.     111221 
 6.     312211
 7.     13112221
 8.     1113213211
 9.     31131211131221
 10.    13211311123113112211
 
From the examples we can see, the (i+1)th sequence is the "count and say" of the ith sequence!
*/


class Solution {
    public String countAndSay(int n) {
        String ans = "1";
        for (int i=2;i<=n;i++) {
            ans = say(ans);
        }
        return ans;
    }
    
    private String say(String s) {
        s=s+"$"; // delimiter
        String res = "";
        int count = 1;
        for (int i=1;i<s.length();i++) {
            if (s.charAt(i)==s.charAt(i-1)) {
                count++;
            }
            else {
                res = res+count+s.charAt(i-1);
                count=1;
            }
        }
        
        return res;
    }
}