class Solution {
    public int maximum69Number (int num) {
        int firstSix = -1;
        
        String n = Integer.toString(num);
        for (int i=0;i<n.length();i++) {
            int x = n.charAt(i)-'0';
            if (x==6 && firstSix==-1)
                firstSix=i;
        }
        
        if (firstSix!=-1)
            n = n.substring(0,firstSix)+"9"+n.substring(firstSix+1);
        
        return Integer.parseInt(n);
    }
}