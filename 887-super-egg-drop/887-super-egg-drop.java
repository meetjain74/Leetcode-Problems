class Solution {
    public int superEggDrop(int k, int n) {
        // dp[i][j] represents min moves for i eggs and j floors
        int dp[][] = new int[k+1][n+1];
        for (int i=0;i<=k;i++) {
            Arrays.fill(dp[i],-1);
        }
        return solve(k,n,dp);
    }
    
    private int solve(int k,int n,int[][] dp) {
        if (k==1) { // If only one egg is given
            // Go from bottom floor to the top
            // Stop when egg breaks on any floor
            // Worst case - n moves
            return n;
        }
        
        if (n==0 || n==1) {
            // If 0 floor - 0 move
            // If 1 floor - 1 move
            return n;
        }
        
        if (dp[k][n]!=-1)
            return dp[k][n];
        
        int minMoves = Integer.MAX_VALUE;
        
        // Go to a floor and break egg 
        int low = 1;
        int high = n;
        while (low<=high) {
            int i = low + (high-low)/2;
            
            // Now go to floor i and drop egg
            // Two cases - Egg breaks or egg does not break
            
            // Egg break at floor i
            // k-1 eggs remaining
            // No need to check top i floors, bottom (i-1) floors remaining
            int movesEggBreak = solve(k-1,i-1,dp); // Left
            
            // Egg do not break at floor i
            // k eggs remaining
            // No need to check bottom i floors, top (n-i) floors remaining
            int movesNotEggBreak = solve(k,n-i,dp); // Right
            
            // Worst case - Maximum of both above cases
            // And one move to check at ith floor 
            int currMoves = 1 + Math.max(movesEggBreak,movesNotEggBreak);
            
            minMoves = Math.min(minMoves,currMoves);
            
            if (movesEggBreak > movesNotEggBreak) {
                // Left part require more moves than right
                // As we need more currMoves value
                // Going to the worst case part
                high = i-1;
            }
            else {
                low = i+1;
            }
        }
        
        return dp[k][n]=minMoves;
    }
}