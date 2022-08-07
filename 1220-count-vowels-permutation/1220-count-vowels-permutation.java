class Solution {
    int MOD = 1000000007;
    public int countVowelPermutation(int n) {
        List<Character> choices = Arrays.asList('a','e','i','o','u');
        int[][] dp = new int[5][n];
        for (int i=0;i<5;i++) {
            Arrays.fill(dp[i],-1);
        }
        return helper(0,n,choices,dp);
    }
    
    private int helper(int i,int n,List<Character> choices,int[][] dp) {
        if (i==n)
            return 1;
        
        int count = 0;
        for (char ch: choices) {
            List<Character> curr = new LinkedList<>();
            int index = index(ch);
            if (dp[index][i]!=-1) {
                count = (count+dp[index][i])%MOD;
                continue;
            }
            
            if (ch=='a') {
                curr.add('e');
            }
            else if (ch=='e') {
                curr.addAll(Arrays.asList('a','i'));
            }
            else if (ch=='i') {
                curr.addAll(Arrays.asList('a','e','o','u'));
            }
            else if (ch=='o') {
                curr.addAll(Arrays.asList('i','u'));
            }
            else if (ch=='u') {
                curr.addAll(Arrays.asList('a'));
            }
            
            dp[index][i] = helper(i+1,n,curr,dp)%MOD;
            count = (count+dp[index][i])%MOD;
        }
        
        return count;
    }
    
    private int index(char ch) {
        switch(ch) {
            case 'a': return 0;
            case 'e': return 1;
            case 'i': return 2;
            case 'o': return 3;
            case 'u': return 4;
        }
        return -1;
    }
}