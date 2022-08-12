class Solution {
    public int minTaps(int n, int[] ranges) {
        int[] jumps = new int[n+1];
        for (int i=0;i<=n;i++) {
            int left = Math.max(0,i-ranges[i]);
            int right = Math.min(n,i+ranges[i]);
            jumps[left] = Math.max(jumps[left],right-left);
        }
        
        int taps = 0; //count of min taps to open
        int max = 0; //Max range right where can be watered
        int current = 0; //Current range right where watered after opening prev tap
        for (int i=0;i<=n;i++) {
            if (i>max)
                return -1;
            if (i==n)
                break;
            max=Math.max(max,i+jumps[i]);
            if (i==current) {
                taps++;
                current=max;
            }
        }
        
        return taps;
    }
}