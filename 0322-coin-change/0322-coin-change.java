class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        long dp[][] = new long[n][amount+1];
        for(long row[]: dp){
            Arrays.fill(row, -1);
        }
        long noOfCoins = f(n-1, coins, amount, dp);
        if(noOfCoins == Integer.MAX_VALUE) return -1;
        return (int)noOfCoins;
    }
    public long f(int ind, int coins[], int amount, long dp[][]){
        if(ind == 0){
            if(amount%coins[0] == 0){
                return (amount / coins[0]);
            }
            return Integer.MAX_VALUE;
        }
        if(dp[ind][amount] != -1) return dp[ind][amount];
        long notTake = f(ind-1, coins, amount, dp);
        long take = Integer.MAX_VALUE;
        if(amount >= coins[ind]){
            take = 1 + f(ind, coins, amount-coins[ind], dp);
        }
        return dp[ind][amount] = Math.min(take, notTake);
    }
}