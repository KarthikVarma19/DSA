class Solution {
    //Dynamic Programming
    //Beats 79%
    // public int maxProfit(int[] prices) {
    //     //initially i will buy on first day 
    //     // i will keep my buy as low as possible
    //     int minBuy = prices[0];
    //     //i will keep my profit as high as possible
    //     int maxProfit = 0;
    //     for(int price: prices){
    //         //i will check if i get maxprofit everyday 
    //         int profit = price - minBuy; 
    //         //i will store the maxprofit as high as possible
    //         maxProfit = profit>maxProfit? profit: maxProfit;
    //         // i will update min buy everyday
    //         minBuy = minBuy>price? price: minBuy;
    //     }
    //     return maxProfit;
    // }


    // //Bruteforce Approach
    // //Time Limit Exceeded 203/212
    // //Because This is a <O(n^2) Approach
    // public int maxProfit(int[] prices) {
    //     int maxProfit = 0;
    //     for(int i = 0; i < prices.length; i++){
    //         int buy = prices[i];
    //         for (int j = i; j < prices.length; j++){
    //             int profit = prices[j] - buy;
    //             maxProfit = maxProfit > profit? maxProfit: profit;
    //         }
    //     }
    //     return maxProfit;
    // }

    //Two Pointer Approach 
    public int maxProfit(int[] prices){
        int buyPointer = 0, sellPointer = 1;
        int maxProfit = 0;
        while(sellPointer < prices.length){
            int profit = prices[sellPointer] - prices[buyPointer];
            if(prices[buyPointer] < prices[sellPointer]){
                maxProfit = Math.max(maxProfit, profit);
            }
            else{
                buyPointer = sellPointer;
            }
            sellPointer += 1;
        }
        return maxProfit;
    }
}