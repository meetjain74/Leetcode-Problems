class Solution {
    public int maxProfit(int[] prices, int fee) {
        
        // Iniital state
        // buyStateProfit represents profit when you have one stock on hold
        // sellStateProfit represents profit when you have no stocks in hand
        int buyStateProfit = -prices[0];
        int sellStateProfit = 0;
        
        for (int i=1;i<prices.length;i++) {
            int newBuyStateProfit = 0;
            int newSellStateProfit = 0;
            
            // BuyStateProfit when stock is bought on ith day
            // with old soldStateProfit in hand
            newBuyStateProfit = Math.max(buyStateProfit,sellStateProfit-prices[i]);
            
            // SoldStateProfit when stock is sold on ith day
            // with old buyStateProfit in hand
            newSellStateProfit = Math.max(sellStateProfit,
                                          buyStateProfit+prices[i]-fee);
            
            buyStateProfit = newBuyStateProfit;
            sellStateProfit = newSellStateProfit;
        }
        
        return sellStateProfit;
    }
}