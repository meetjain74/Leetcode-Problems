class Solution {
    public String addBinary(String a, String b) {
        int i=a.length()-1;
        int j=b.length()-1;
        char carry='0';
        StringBuilder res=new StringBuilder();
        
        while (i>=0 && j>=0) {
            char x = a.charAt(i);
            char y = b.charAt(j);
            if (x=='0' && y=='0') {
                res.append(carry);
                carry = '0';
            }
            else if ((x=='0' && y=='1') || (x=='1' && y=='0')) {
                if (carry=='1') {
                    res.append('0');
                }
                else {
                    res.append('1');
                }
            }
            else { //x and y both 1
                if (carry=='0') {
                    res.append('0');
                }
                else {
                    res.append('1');
                }
                carry = '1';
            }
            i--;
            j--;
        }
        
        while (i>=0) {
            char x = a.charAt(i);
            if (x=='0' && carry=='0') {
                res.append('0');
            }
            else if ((x=='0' && carry=='1') || (x=='1' && carry=='0')) {
                res.append('1');
                carry = '0';
            }
            else { //x and carry both 1
                res.append('0');
                carry = '1';
            }
            i--;
        }
        
        while (j>=0) {
            char y = b.charAt(j);
            if (y=='0' && carry=='0') {
                res.append('0');
            }
            else if ((y=='0' && carry=='1') || (y=='1' && carry=='0')) {
                res.append('1');
                carry = '0';
            }
            else { //y and carry both 1
                res.append('0');
                carry = '1';
            }
            j--;
        }
        
        if (carry=='1') {
            res.append('1');
        }
        
        return res.reverse().toString();
    }
}