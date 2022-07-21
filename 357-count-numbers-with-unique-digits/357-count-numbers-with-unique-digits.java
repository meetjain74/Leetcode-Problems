class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n==0)
            return 1;
        
        int ans = 0;
        for (int i=1;i<=n;i++) {
            ans += countUniqueNumbers(i);
        }
        
        return ans;
    }
    
    // Returns count of unique n digit numbers (Exactly length n)
    private int countUniqueNumbers(int n) {
        if (n==1)
            return 10;
        
        int count = 9;
        int curr = 9;
        for (int i=2;i<=n;i++) {
            count = count*curr;
            curr--;
        }
        return count;
    }
}