class Solution {
    public String intToRoman(int num) {
        String dictionary[] = 
            {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int value[] = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        
        String output = "";
        int i=0;
        while (num>0) {
            while (num>=value[i]) {
                num -= value[i];
                output = output + dictionary[i];
            }
            i++;
        }
        
        return output;
    }
}