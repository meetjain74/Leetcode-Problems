class Solution {
    public int addDigits(int num) {
        int current = num;
        while (current/10!=0) {
            current=getNext(current);
        }
        return current;
    }
    
    private int getNext(int n) {
        int result = 0;
        while (n!=0) {
            int rem = n%10;
            n = n/10;
            result += rem;
        }
        return result;
    }
}