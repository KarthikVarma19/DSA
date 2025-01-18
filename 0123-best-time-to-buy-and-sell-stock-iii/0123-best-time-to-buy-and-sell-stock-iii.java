class Solution {
    //Space Optimisation Code
    public int maxProfit(int[] prices) {
        int n = prices.length;

        return f(prices);
    }
    public int f(int[] prices){
        int ahead[][] = new int[2][3];
        int curi[][] = new int[2][3];
        int n = prices.length;

        for(int ind = n-1; ind>=0; ind--){
            for(int buy = 0; buy < 2; buy++){
                for(int times = 1; times <=2; times++){
                    int profit = 0;
                    if(buy == 1){
                        if(times > 0){
                            profit = Math.max((-prices[ind] + ahead[0][times])
                            ,(0 + ahead[1][times]));
                        }  
                    }
                    else{
                        profit = Math.max((prices[ind] + ahead[1][times-1])
                                    , (0 + ahead[0][times]));
                    }
                    curi[buy][times] = profit;
                }
            }
            ahead = curi;        
        }
        return ahead[1][2];
    }
   
}