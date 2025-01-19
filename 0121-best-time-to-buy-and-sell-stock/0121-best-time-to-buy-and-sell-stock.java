class Solution {
    public int maxProfit(int[] prices) {
        int minBuy = prices[0];
        int maxProfit = 0;
        for(int price: prices){
            int profit = price - minBuy; // 0 
            maxProfit = Math.max(maxProfit, profit); // 0 
            minBuy = Math.min(minBuy, price); // 7 
        }
        return maxProfit;
    }
}