class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n+1][2][3];

        return f(prices, dp);
    }
    //three changining pararmetesr so three for loops 
    // ind n - 1to 0
    // buy o to 1 
    // times 1 to 2 
    public int f(int[] prices, int dp[][][]){
        
        int n = prices.length;
        //Initially Everything will be 0 right so no need
        // for(int buy = 0; buy < 2; buy++){
        //     for(int times = 1; times < 3; times++){
        //         dp[n][buy][times] = 0;
        //     }
        // }
        for(int ind = n-1; ind>=0; ind--){
            for(int buy = 0; buy < 2; buy++){
                for(int times = 1; times <=2; times++){
                    int profit = 0;
                    if(buy == 1){
                        if(times > 0){
                            profit = Math.max((-prices[ind] + dp[ind+1][0][times])
                            ,(0 + dp[ind+1][1][times]));
                        }  
                        // else{
                        //     return dp[ind]0;
                        // }
                    }
                    else{
                        profit = Math.max((prices[ind] + dp[ind+1][1][times-1])
                                    , (0 + dp[ind+1][0][times]));
                    }
                    dp[ind][buy][times] = profit;
                }
            }        
        }
        return dp[0][1][2];
    }
    
    /* Memoization Code
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n][2][3];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 2; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }

        return f(0, 1, 2, prices, dp);
    }
    //Three Changing Parameters
    public int f(int ind, int buy, int times, int[] prices, int dp[][][]){
        if(ind == prices.length){
            return 0;
        }
        if(dp[ind][buy][times] != -1){
            return dp[ind][buy][times];
        }
        int profit = 0;
        if(buy == 1){
            if(times > 0){
                profit = Math.max((-prices[ind] + f(ind+1, 0, times-1, prices, dp))
                                ,(0 + f(ind+1, 1, times, prices, dp)));
            }
            else{
                return 0;
            }
        }
        else{
            profit = Math.max((prices[ind] + f(ind+1, 1, times, prices, dp))
                        , (0 + f(ind+1, 0, times, prices, dp)));
        }
        return dp[ind][buy][times] = profit;
    }
    */
    
    
    
    /* Recursive Code Passes: - 201/214 Time Limit Exceeded
    public int maxProfit(int[] prices) {
        return f(0, 1, 2, prices);
    }
    public int f(int ind, int buy, int times, int[] prices){
        if(ind == prices.length){
            return 0;
        }
        
        int profit = 0;
        if(buy == 1){
            if(times>0){
                profit = Math.max((-prices[ind] + f(ind+1, 0, times-1, prices))
                                ,(0 + f(ind+1, 1, times, prices)));
            }
            else{
                return 0;
            }
        }
        else{
            profit = Math.max((prices[ind] + f(ind+1, 1, times, prices))
                        , (0 + f(ind+1, 0, times, prices)));
        }
        return profit;
    }
    */
}