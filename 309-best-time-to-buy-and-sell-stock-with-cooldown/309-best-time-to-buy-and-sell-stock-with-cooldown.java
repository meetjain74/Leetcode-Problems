class Solution {
    public int maxProfit(int[] prices) {
        
        // Iniital state
        // buyStateProfit represents profit when you have one stock on hold
        // sellStateProfit represents profit when you have no stocks in hand
        // coolDownStateProfit represents profit when you have cooldown one day
        int buyStateProfit = -prices[0];
        int sellStateProfit = 0;
        int coolDownStateProfit = 0;
        
        for (int i=1;i<prices.length;i++) {
            int newBuyStateProfit = 0;
            int newSellStateProfit = 0;
            int newCoolDownStateProfit = 0;
            
            // BuyStateProfit when stock is bought on ith day
            // with old coolDownStateProfit in hand
            newBuyStateProfit = Math.max(buyStateProfit,
                                         coolDownStateProfit-prices[i]);
            
            // SoldStateProfit when stock is sold on ith day
            // with old buyStateProfit in hand
            newSellStateProfit = Math.max(sellStateProfit,
                                          buyStateProfit+prices[i]);
            
            newCoolDownStateProfit = Math.max(coolDownStateProfit,
                                             sellStateProfit);
            
            buyStateProfit = newBuyStateProfit;
            sellStateProfit = newSellStateProfit;
            coolDownStateProfit = newCoolDownStateProfit;
        }
        
        return sellStateProfit;
    }
}