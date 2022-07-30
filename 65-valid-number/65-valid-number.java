class Solution {
    public boolean isNumber(String s) {
        boolean seenNum = false;
        boolean seenE = false;
        boolean seenDot = false;
        
        for (int i=0;i<s.length();i++) {
            char c=s.charAt(i);
            switch(c) {
                case '.':
                    if (seenDot || seenE) 
                        return false;
                    seenDot = true;
                    break;
                case 'E':
                case 'e':
                    if (seenE || !seenNum) 
                        return false;
                    seenE = true;
                    seenNum = false;
                    break;
                case '+':
                case '-':
                    if (i!=0 && s.charAt(i-1)!='e') 
                        return false;
                    seenNum = false;
                    break;
                default:
                    if (c-'0'<0 || c-'0'>9) 
                        return false;
                    seenNum = true;
            }
        }
        
        return seenNum;
    }
}