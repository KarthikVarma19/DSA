class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        long dp[] = new long[amount+1];
        for(int am = 0; am <= amount; am++){
            if(am%coins[0] == 0){
                dp[am] = (am / coins[0]);
            }
            else{
                dp[am] = Integer.MAX_VALUE;
            }  
        }
        for(int ind = 1; ind < n; ind++){
            for(int am = 0; am <= amount; am++){
                long notTake = dp[am];
                long take = Integer.MAX_VALUE;
                if(am >= coins[ind]){
                    take = 1 + dp[am-coins[ind]];
                }
                dp[am] = Math.min(take, notTake);
            }
        }
        long noOfCoins = dp[amount];
        if(noOfCoins == Integer.MAX_VALUE) return -1;
        return (int)noOfCoins;
    }
}