class Solution {
    // Josephus problem
    public int findTheWinner(int n, int k) {
        if (n==1)
            return 1;
        
        int x = (findTheWinner(n-1,k)+k)%n;
        return x==0 ? n : x;
    }
}