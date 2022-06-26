class Solution {
    public int titleToNumber(String columnTitle) {
        int size = columnTitle.length();
        int number = 0;
        
        int k = 1;
        for (int i=size-1;i>=0;i--) {
            char ch = columnTitle.charAt(i);
            number = number + (ch-'A'+1)*k;
            k=k*26;
        }
        return number;
    }
}