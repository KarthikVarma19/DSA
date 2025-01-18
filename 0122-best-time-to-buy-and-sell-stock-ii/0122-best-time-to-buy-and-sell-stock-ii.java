class Solution {
     public int maxProfit(int[] prices) {
        return f(prices);
    }
    public int f(int prices[]){
        int n = prices.length;
        int prev[] = new int[2];
        int curi[] = new int[2];
        prev[0] = 0;
        prev[1] = 0;

        for(int ind=n-1;ind>=0;ind--){
            for(int buy=0;buy<=1;buy++){
                int profit = 0;
                if(buy == 1){
                    profit = Math.max((-prices[ind] + prev[0])
                                                ,(0 + prev[1]));
                }
                else{
                    profit = Math.max((prices[ind] + prev[1]), 
                                    (0 + prev[0]));
                }
                curi[buy] = profit;
            }
            prev = curi;
        }

        return prev[1];
    }




    /*
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n+1][2];
        return f(prices, dp);
    }
    public int f(int prices[], int dp[][]){
        int n = prices.length;
        dp[n][0] = 0;
        dp[n][1] = 0;

        for(int ind=n-1;ind>=0;ind--){
            for(int buy=0;buy<=1;buy++){
                int profit = 0;
                if(buy == 1){
                    profit = Math.max((-prices[ind] + dp[ind+1][0])
                                                ,(0 + dp[ind+1][1]));
                }
                else{
                    profit = Math.max((prices[ind] + dp[ind+1][1]), 
                                    (0 + dp[ind+1][0]));
                }
                dp[ind][buy] = profit;
            }
        }

        return dp[0][1];
    }
    */




    /*
    Memoization Code
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n][2];
        for(int row[]: dp){
            Arrays.fill(row, -1);
        }
        return f(0, 1, prices, dp);
    }
    public int f(int ind, int buy, int prices[], int dp[][]){
        if(ind == prices.length){
            return 0;
        }
        if(dp[ind][buy] != -1){
            return dp[ind][buy];
        }
        int profit = 0;
        if(buy == 1){
            profit = Math.max((-prices[ind] + f(ind+1, 0, prices, dp))
                                                ,(0 + f(ind+1, 1, prices, dp)));
        }
        else{
            profit = Math.max((prices[ind] + f(ind+1, 1, prices, dp)), 
                                    (0 + f(ind+1, 0, prices, dp)));
        }
        return dp[ind][buy] = profit;
    }
    */
}