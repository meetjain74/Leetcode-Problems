class Solution {
    public int maximum69Number (int num) {
        return method2(num);
    }
    
    public int method1(int num) {
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
    
    public int method2(int num) {
        int f  = num/1000;
        int s  = num/100%10;
        int t  = num/10%10;
        int foo  = num%10;
        if(f==6) num+=3000;
        else if(s==6) num+=300;
        else if(t==6) num+=30;
        else if(foo==6) num+=3;
        return num;
    }
}