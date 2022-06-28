class Solution {
    // Josephus problem
    public int findTheWinner(int n, int k) {
        if (n==1)
            return 1;
        
        return 1+(findTheWinner(n-1,k)+k-1)%n;
    }
}