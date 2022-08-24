class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        
        int[] dp = new int[(int)Math.pow(2,n)];
        dp[0]=0;
        dp[1]=1;
        for (int i=2;i<=n;i++) {
            int start = (int)Math.pow(2,i-1);
            int end = (int)Math.pow(2,i);
            int curr = 0;
            for (int k=end-1;k>=start;k--) {
                dp[k] = dp[curr]+start;
                curr++;
            }
        }
        
        for (int i=0;i<dp.length;i++) {
            ans.add(dp[i]);
        }
        
        return ans;
    }
}