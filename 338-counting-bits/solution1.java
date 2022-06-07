class Solution {
    public int[] countBits(int n) {
        int ans[] = new int[n+1];
        for (int i=0;i<=n;i++) {
            ans[i]=count(i);
        }
        return ans;
    }
    
    public int count(int num) {
        int ans = 0;
        while (num>0) {
            num = num&(num-1); // Removes the last set bit 
            ans++;
        }
        return ans;
    }

}
