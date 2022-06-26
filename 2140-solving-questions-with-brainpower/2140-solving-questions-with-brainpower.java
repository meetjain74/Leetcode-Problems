class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        
        // dp[i] represents maximum points that can be earned
        // by solving questions from i+1 to n
        long dp[] = new long[n];
        
        dp[n-1] = questions[n-1][0]; // Points to solve last question
        
        for (int i=n-2;i>=0;i--) {
            int brainpower = questions[i][1];
            
            // If pick this question, skip brainpower questions further
            // Else skip this question, go to next question
            
            if (i+brainpower+1<n) {
                dp[i] = Math.max(dp[i+1], 
                            questions[i][0]+dp[i+brainpower+1]);
            }
            else {
                dp[i] = Math.max(dp[i+1],questions[i][0]);
            }
        }
        
        return dp[0];
    }
}