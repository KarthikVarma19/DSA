class Solution {
    //Tabulation Code 
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n+1][3][k+1];
        return f(k, prices, dp);
    }
    //Bottom-Up Approach
    public int f(int k, int prices[], int dp[][][]){
        int n = prices.length;
        //No Problem to Declare Because Initially dp consistis of zero's 
        //Declare the Base Case 
        for(int buy = 0; buy < 3; buy++){
            for(int ki = 0; ki < k; ki++){
                dp[n][buy][ki] = 0;
            }
        }

        //ind n-1 to 0 
        //buy 0 to 1 
        //k should be 0 to k
        for(int ind = n-1; ind >= 0; ind--){
            for(int buy = 0; buy < 2; buy++){
                for(int ki = 1; ki <= k; ki++){
                    int profit = 0;
                    if(buy == 1){
                        if(ki > 0){
                            profit = Math.max((-prices[ind] + dp[ind+1][0][ki]),
                                             (dp[ind+1][1][ki]));
                        }
                    }
                    else{
                        profit = Math.max((prices[ind] + dp[ind+1][1][ki-1]), 
                        (dp[ind+1][0][ki]));
                    }

                    dp[ind][buy][ki] = profit;
                }
            }
        }
        
        return dp[0][1][k];
    }
    /*
    //Memoization Code
    //Beats 32%
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
    //Three Changing Parameters ind, buy, k so 3D DP Array is Required
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
    */





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