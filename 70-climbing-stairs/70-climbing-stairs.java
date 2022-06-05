class Solution {
    public int climbStairs(int n) {
        int ways[] = new int[n+1];
        ways[1] = 1;
        
        for (int i=2;i<=n;i++) {
            if (i==2)
                ways[i]=2; // 1+1 and 2
            else
                ways[i]=ways[i-1]+ways[i-2];
        }
        
        return ways[n];
    }
}