class Solution {
    //Tabulation Code
    int fee;
    public int maxProfit(int[] prices, int fee) {
        this.fee = fee;
        return f(prices);
    }
    //Two Changing Parameters
    public int f(int prices[]){
        int n = prices.length;
        int dp[][] = new int[n+1][2];
        dp[n][0] = 0;
        dp[n][1] = 0;
        //ind n-1 to 0
        //buy o to 1

        for(int ind = n-1; ind >= 0; ind--){
            for(int buy = 0; buy < 2; buy++){
                int profit = 0;
                if(buy == 1){
                    profit = Math.max((-prices[ind] + dp[ind+1][0])
                            , (dp[ind+1][1]));
                }
                else{
                    profit = Math.max((-fee + prices[ind] + dp[ind+1][1])
                    , (dp[ind+1][0]));
                }
                dp[ind][buy] = profit;
            }
        }
        return dp[0][1];
    } 


    /*
    //Memoization Code
    // Beats 27%
    int fee;
    public int maxProfit(int[] prices, int fee) {
        this.fee = fee;
        int n = prices.length;
        int dp[][] = new int[n][2];
        for(int row[]: dp){
            Arrays.fill(row, -1);
        }
        return f(0,1,prices, dp);
    }
    //Two Changing Parameters
    public int f(int ind, int buy, int prices[], int dp[][]){
        if(ind == prices.length){
            return 0;
        }
        if(dp[ind][buy] != -1){
            return dp[ind][buy];
        }
        int profit = 0;
        if(buy == 1){
            profit = Math.max((-prices[ind] + f(ind+1, 0, prices, dp)), (f(ind+1, 1, prices, dp)));
        }
        else{
            profit = Math.max((-fee + prices[ind] + f(ind+1, 1, prices, dp)), (0 + f(ind+1, 0, prices, dp)));
        }
        return dp[ind][buy] = profit;
    } 
    */
    
    /*
    //Recursion Code
    //Time Limit Exceeded 19/44 testcases passed
    int fee;
    public int maxProfit(int[] prices, int fee) {
        this.fee = fee;
        return f(0,1,prices);
    }
    public int f(int ind, int buy, int prices[]){
        if(ind == prices.length){
            return 0;
        }
        int profit = 0;
        if(buy == 1){
            profit = Math.max((-prices[ind] + f(ind+1, 0, prices)), (f(ind+1, 1, prices)));
        }
        else{
            profit = Math.max((-fee + prices[ind] + f(ind+1, 1, prices)), (0 + f(ind+1, 0, prices)));
        }
        return profit;
    }
    */
   
}