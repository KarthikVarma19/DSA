class Solution {
    public boolean canCross(int[] stones) {
        if(stones[1] != 1) return false;
        int dp[][] = new int[stones.length+1][stones.length+1];
        for(int row[]: dp){
            Arrays.fill(row, -1);
        }
        return f(1, 1, stones, dp); 
    }
    public boolean f(int i, int k, int stones[], int dp[][]){
        if(i == stones.length-1) return true;
        if(dp[i][k] != -1){
            return dp[i][k] == 1;
        }
        for(int j = i + 1; j < stones.length; j++){
            int gap = stones[j] - stones[i];
            if(gap <= k + 1 && gap >= k - 1){
                if(f(j, gap, stones, dp)){
                    dp[i][k] = 1;
                    return true;
                }
            }
            else if(gap > k + 1){
                break;
            }
        }
        dp[i][k] = 0;
        return false;
    }
}