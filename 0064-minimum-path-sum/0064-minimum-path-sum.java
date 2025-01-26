class Solution {
    //In Tabulation Solution, It Beats 30%
    //Time Complexity:- O((m*n) 
    //Space Complexity:-  O(m*n)
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[] = new int[n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0){
                    dp[j] = grid[i][j];
                    continue;
                }
                int up = (int)1e7;
                if(i > 0){
                    up = dp[j];
                }
                int left = (int)1e7;
                if(j > 0){
                    left = dp[j-1];
                }
                dp[j] = (Math.min(up, left) + grid[i][j]);
            }
        }
        return dp[n-1];   
    }
}