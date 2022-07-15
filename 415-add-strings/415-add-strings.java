class Solution {
    public String addStrings(String num1, String num2) {
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
}