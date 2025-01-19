class Solution {
    public int maxProfit(int[] prices) {
        //initially i will buy on first day 
        // i will keep my buy as low as possible
        int minBuy = prices[0];
        //i will keep my profit as high as possible
        int maxProfit = 0;
        for(int price: prices){
            //i will check if i get maxprofit everyday 
            int profit = price - minBuy; 
            //i will store the maxprofit as high as possible
            maxProfit = profit>maxProfit? profit: maxProfit;
            // i will update min buy everyday
            minBuy = minBuy>price? price: minBuy;
        }
        return maxProfit;
    }
}