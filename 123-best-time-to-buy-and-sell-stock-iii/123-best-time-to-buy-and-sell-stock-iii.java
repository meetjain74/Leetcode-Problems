class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        
        // Iterating from left to right
        // Creating a dp of array represnting maximum profit if sold till today
        
        int minSoFar = prices[0]; // Represents buy
        int profitIfSoldToday = 0;
        int dpleft[] = new int[n];
        
        for (int i=1;i<n;i++) {
            if (prices[i]<minSoFar) {
                minSoFar = prices[i];
            }
            
            profitIfSoldToday = prices[i]-minSoFar;
            
            if (profitIfSoldToday > dpleft[i-1]) {
                dpleft[i] = profitIfSoldToday;
            }
            else {
                dpleft[i] = dpleft[i-1];
            }
        }
        
        // Iterating from right to left
        // Creating a dp of array representing maximum profit 
        // if bought today or after today
        
        int maxAfterToday = prices[n-1]; // Represents sell
        int profitIfBoughtToday = 0;
        int dpright[] = new int[n];
        
        for (int i=n-2;i>=0;i--) {
            if (prices[i]>maxAfterToday) {
                maxAfterToday = prices[i];
            }
            
            profitIfBoughtToday = maxAfterToday-prices[i];
            
            dpright[i] = Math.max(dpright[i+1],profitIfBoughtToday);
        }
        
        // Now at a particular day i
        // dpleft[i] represents maximum profit if sold till today - Tx1
        // dpright[i] represents maximum profit if bought today or after today - Tx2
        // Maximum sum of the two is the maximum profit answer
        
        int maxProfit = dpleft[0]+dpright[0];
        for (int i=1;i<n;i++) {
            int temp = dpleft[i]+dpright[i];
            maxProfit = Math.max(maxProfit,temp);
        }
        
        return maxProfit;
    }
}