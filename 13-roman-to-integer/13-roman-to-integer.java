class Solution {
    public int romanToInt(String s) {
        int num = 0;
        int prev = 0;
        int curr;
        for(int i=s.length()-1;i>=0;i--){
            curr = getNum(s.charAt(i));
            if(curr < prev){
                num -= curr;
            }else {
                num += curr;
            }
            prev = curr;
        }
        return num;
    }
    
    private int getNum(char c){
        switch(c){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}