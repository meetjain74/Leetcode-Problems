class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int satisfied = 0;
        
        // When don't use secret technique
        for (int i=0;i<n;i++) {
            if (grumpy[i]==0)
                satisfied += customers[i];
        }
        
        // Use secret technique now for minutes 
        // Sliding window
        int start=0;
        int maxSatisfied=0;
        for (int end=0;end<n;end++) {
            
            // If customer is grumpy
            if (grumpy[end]==1)
                satisfied+=customers[end];
            
            if (end-start+1==minutes) {
                maxSatisfied = Math.max(maxSatisfied,satisfied);
                if (grumpy[start]==1)
                    satisfied-=customers[start];
                start++;
            }
        }
        
        return maxSatisfied;
    }
}