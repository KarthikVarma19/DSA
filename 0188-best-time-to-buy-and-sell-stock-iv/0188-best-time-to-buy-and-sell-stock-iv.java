class Solution {
    //Space Optimisation Code 
    public int maxProfit(int k, int[] prices) {
        return f(k, prices);
    }

    public int f(int k, int prices[]){
        int n = prices.length;
        int ahead[][] = new int[3][k+1];
        int curi[][] = new int[3][k+1];

        for(int ind = n-1; ind >= 0; ind--){
            for(int buy = 0; buy < 2; buy++){
                for(int ki = 1; ki <= k; ki++){
                    int profit = 0;
                    if(buy == 1){
                        if(ki > 0){
                            profit = Math.max((-prices[ind] + ahead[0][ki]),
                                             (ahead[1][ki]));
                        }
                    }
                    else{
                        profit = Math.max((prices[ind] + ahead[1][ki-1]), 
                        (ahead[0][ki]));
                    }

                    curi[buy][ki] = profit;
                }
            }
            ahead = curi;
        }
        
        return ahead[1][k];
    }
}