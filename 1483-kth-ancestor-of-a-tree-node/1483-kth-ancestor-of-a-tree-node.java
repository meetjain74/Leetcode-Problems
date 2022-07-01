class TreeAncestor {
    
    // Binary lifting Problem
    
    int maxPower;
    
    // dp[i][j] represents (2^i)th ancestor of jth node i.e
    // dp[0][j] represents first(2^0) ancestor of jth node which is given
    // dp[1][j] represents second(2^1) ancestor of jth node
    // dp[2][j] represents fourth(2^2) ancestor of jth node
    // and so on till i=maxPower possible in binary tree
    int dp[][];

    
    // Building dp - O(nlogn)
    public TreeAncestor(int n, int[] parent) {
        
        // maxPower is log of n with base 2
        this.maxPower = (int)(Math.log(n)/Math.log(2)) + 1;
        this.dp = new int[maxPower][n];
        
        // dp[0][j] i.e first parent of every node is given i.e parent
        dp[0] = parent;
        
        for (int i=1;i<maxPower;i++) {
            
            for (int j=0;j<n;j++) {
                
                // jth node 2^(i-1) th ancestor
                int prev_ancestor = dp[i-1][j];
                
                if (prev_ancestor==-1) { // No more ancestors
                    dp[i][j] = -1;
                }
                
                else {
                    // 2^i = 2^(i-1) + 2^(i-1)
                    // Say 2^(i-1) th parent of j is FATHER
                    // Then 2^ith parent  of j will be 2^(i-1) th parent of FATHER
                    // i.e Ancestor(j,2^i) = Ancestor( Ancestor(j,2^i-1), 2^i-1)
                    dp[i][j] = dp[i-1][prev_ancestor];
                }
            }
            
        }
    }
    
    // Binary search - O(logn)
    public int getKthAncestor(int node, int k) {
        int currPower = this.maxPower-1;
        
        while (k!=0 && node!=-1) {
            // Move to node ancestors in steps of binary notation of node
            // Ex - 13 i.e 1101 i.e first go to 8th ancestor then 4th and then first
            // In steps of 2^currPower, 2^(currPower-1) and so on...
            if ( k >= (1<<currPower) ) {
                // k is greater than 2^currPower
                node = dp[currPower][node];
                k -= 1<<currPower;
            }
            
            currPower -= 1; // For next step
        }
        
        return node; 
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */