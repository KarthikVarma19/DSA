class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        long dp[][] = new long[n][amount+1];
        for(int am = 0; am <= amount; am++){
            if(am%coins[0] == 0){
                dp[0][am] = (am / coins[0]);
            }
            else{
                dp[0][am] = Integer.MAX_VALUE;
            }  
        }
        for(int ind = 1; ind < n; ind++){
            for(int am = 0; am <= amount; am++){
                long notTake = dp[ind-1][am];
                long take = Integer.MAX_VALUE;
                if(am >= coins[ind]){
                    take = 1 + dp[ind][am-coins[ind]];
                }
                dp[ind][am] = Math.min(take, notTake);
            }
        }
        long noOfCoins = dp[n-1][amount];
        if(noOfCoins == Integer.MAX_VALUE) return -1;
        return (int)noOfCoins;
    }
}