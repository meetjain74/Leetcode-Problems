class Solution {
    public String discountPrices(String sentence, int discount) {
        int n = sentence.length();
        long num = -1;
        StringBuilder res = new StringBuilder();
        boolean countNum=false;
        for (int i=0;i<n;i++) {
            char ch = sentence.charAt(i);
            if (ch=='$' && (i==0 || sentence.charAt(i-1)==' ')) {
                res.append(ch);
                countNum=true;
                continue;
            }
            
            if (Character.isDigit(ch) && countNum) {
                if (num==-1) num=0;
                num = (num*10)+(ch-'0');
                continue;
            }
            else if (countNum && num!=-1) {
                if (ch==' ') {
                    double num2 = num*(100-discount)*1.0/100;
                    res.append(String.format("%.2f",num2));
                }
                else {
                    res.append(num);
                }
            }
            
            countNum=false;
            num = -1;
            res.append(ch);
        }
        
        if (countNum && num!=-1) {
            double num2 = num*(100-discount)*1.0/100;
            res.append(String.format("%.2f",num2));
        }
        
        return res.toString();
    }
}