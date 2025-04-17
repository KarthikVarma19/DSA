class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int dp[][] = new int[n][367];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(n-1, 366, days, costs, dp);
    }
    public int solve(int ind, int valid, int days[], int costs[], int dp[][]){
        if(ind == 0){
            if(valid <= days[ind]){
                return 0;
            }
            return Math.min(costs[0], Math.min(costs[1], costs[2]));
        }
        if(valid < 1){
            valid = 1;
        }
        if(dp[ind][valid] != -1){
            return dp[ind][valid];
        }
        if(valid > days[ind]){
            int oneDay = costs[0] + solve(ind-1, days[ind], days, costs, dp);

            int sevenDay = costs[1] + solve(ind-1, days[ind]-6, days, costs, dp);

            int thirtyDay = costs[2] + solve(ind-1, days[ind]-29, days, costs, dp);

            return dp[ind][valid] = Math.min(oneDay, Math.min(sevenDay, thirtyDay));
        }
        return dp[ind][valid] = solve(ind-1, valid, days, costs, dp);
    }
}