class Solution {
    // Possible moves for knight from each number (Corresponding index)
    String[] moves = {"46","68","79","48","390","","170","26","13","24"};
    
    public int knightDialer(int n) {
        if (n==1)
            return 10;
        
        int ans = 0;
        
        // Count stores number of that num at each level
        int count[] = new int[10];
        Arrays.fill(count,1); // At level 1
        count[5]=0;
        
        for (int move=2;move<=n;move++) {
            // At every level
            int temp[] = new int[10];
            for (int i=0;i<10;i++) {
                String curr = moves[i];
                for (int j=0,len=curr.length();j<len;j++) {
                    int x = curr.charAt(j)-'0';
                    temp[x] = (temp[x] + count[i])%1000000007;
                }
            }
            count = Arrays.copyOf(temp,10);
        }
        
        for (int c: count) {
            ans = (ans+c)%1000000007;
        }
        
        return ans;
    }
}