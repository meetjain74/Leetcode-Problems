class Solution {
    public int deleteAndEarn(int[] nums) {
        HashMap<Integer,Integer> points = new HashMap<>();
        int maxNum = 0;
        for (int i: nums) {
            points.put(i,points.getOrDefault(i,0)+i);
            maxNum=Math.max(maxNum,i);
        }
        
        // dp[i] stores max points that can be achieved using 0 to i 
        int dp[] = new int[maxNum+1];
        dp[0] = 0; 
        dp[1] = points.getOrDefault(1,0); // Count of occurences of 1
        
        for (int i=2;i<maxNum+1;i++) {
            int gain = points.getOrDefault(i,0);
            dp[i] = Math.max(dp[i-1],dp[i-2]+gain);
        }
        
        return dp[maxNum];
    }
}