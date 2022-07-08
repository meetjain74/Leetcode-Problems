class Solution {
    public int repeatedStringMatch(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        
        int repeat = (int)Math.ceil(bLen*1.0/aLen);
        
        String temp="";
        for (int i=0;i<repeat;i++) {
            temp += a;
        }
        
        if (temp.contains(b))
            return repeat;
        
        temp = temp+a;
        if (temp.contains(b))
            return repeat+1;
        
        return -1;
    }
}