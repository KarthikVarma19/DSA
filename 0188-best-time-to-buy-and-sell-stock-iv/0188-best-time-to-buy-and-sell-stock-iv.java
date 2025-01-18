class Solution {
    //Memoization Code
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n][3][k+1];
        for(int ind = 0; ind < n; ind++){
            for(int buy = 0; buy < 3; buy++){
                Arrays.fill(dp[ind][buy], -1);
            }
        }
        return f(0, 1, k, prices, dp);
    }
    //Three Changing Parameters ind, buy, k
    public int f(int ind, int buy,  int k, int prices[], int dp[][][]){
        if(ind == prices.length || k == 0){
            return 0;
        }
        if(dp[ind][buy][k] != -1){
            return dp[ind][buy][k];
        }
        int profit = 0;
        if(buy == 1){
            if(k > 0){
                profit = Math.max((-prices[ind] + f(ind+1, 0, k, prices, dp)), (f(ind+1, 1, k, prices, dp)));
            }
        }
        else{
            profit = Math.max((prices[ind] + f(ind+1, 1, k-1, prices, dp)), (f(ind+1, 0, k, prices, dp)));
        }

        return dp[ind][buy][k] = profit;
    }

    /*
    //Recursion Code
    //Got TLE at 206/210 testcases passed
    public int maxProfit(int k, int[] prices) {
        return f(0, 1, k, prices);
    }
    public int f(int ind, int buy,  int k, int prices[]){
        if(ind == prices.length || k == 0){
            return 0;
        }
        int profit = 0;
        if(buy == 1){
            if(k > 0){
                profit = Math.max((-prices[ind] + f(ind+1, 0, k, prices)), (f(ind+1, 1, k, prices)));
            }
        }
        else{
            profit = Math.max((prices[ind] + f(ind+1, 1, k-1, prices)), (f(ind+1, 0, k, prices)));
        }

        return profit;
    }
    */
}