class Solution {
    public String multiply(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        
        if (n1<n2)
            return multiply(num2,num1);
        
        // Now n1>=n2
        
        String res = "";
        
        for (int i=0;i<n2;i++) {
            // Take one character of num2 at a time
            // and multply it by num1
            
            int x = num2.charAt(i)-'0';
            String temp = "";
            int carry = 0;
            for (int j=n1-1;j>=0;j--) {
                int y = num1.charAt(j)-'0';
                int z = x*y+carry;
                carry = z/10;
                z = z%10;
                temp = z+temp;
            }
            if (carry!=0)
                temp = carry+temp;
            
            if (res.equals(""))
                res=temp;
            else 
                res = addTwoStrings(res+"0",temp);
        }
        
        res=removeFrontZeroes(res);
        return res;
    }
    
    
    private String addTwoStrings(String num1, String num2) {
        String res = "";
        int i=num1.length()-1;
        int j=num2.length()-1;
        
        int count=0;
        
        while (i>=0 && j>=0) {
            int x = num1.charAt(i)-'0';
            int y = num2.charAt(j)-'0';
            
            int z = x+y+count;
            count = z/10;
            z = z%10;
            
            res = z+res;
            i--;
            j--;
        }
        
        while (i>=0) {
            int x = num1.charAt(i)-'0';
            int z = x+count;
            count = z/10;
            z = z%10;
            res = z+res;
            i--;
        }
        
        while (j>=0) {
            int y = num2.charAt(j)-'0';
            int z = y+count;
            count = z/10;
            z = z%10;
            res = z+res;
            j--;
        }
        
        if (count!=0)
            res = count+res;
        
        return res;
    }
    
    private String removeFrontZeroes(String s) {
        int i;
        for (i=0;i<s.length()-1;i++) {
            if (s.charAt(i)!='0')
                break;
        }
        return s.substring(i);
    }
}