class Solution {
    public int findNthDigit(int n) {
        long digits = 9;
        int first = 1;
        int length = 1;
        while (n > length*digits) {
            n -= length*digits;
            length++;
            first *= 10;
            digits *= 10;
        }
        
        
        
        // First now points to first kth digit number (1,10,100,1000....etc)
        // where nth digit lies in a k digit number
        
        first = first + (n-1)/length;
        
        // First now points to the number which contains the nth digit
        
        String num = Integer.toString(first);
        char digit = num.charAt((n-1)%length);
        
        return digit-'0';
    }
}