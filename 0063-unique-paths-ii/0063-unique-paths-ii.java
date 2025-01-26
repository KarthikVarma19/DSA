class Solution {
    //In, Tabulation Solution. It Beats 100%
    //Time Complexity:- O(m*n)
    //Spac Complexity:- O(m*n)
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(grid[0][0] == 1) return 0;
        int dp[][] = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    continue;
                }
                else if(i == 0 && j == 0){
                    dp[i][j] = 1;
                    continue;
                }
                int up = 0, left = 0;
                if(i-1 >= 0){
                    up = dp[i-1][j];
                }
                if(j-1 >= 0){
                    left = dp[i][j-1];
                }
                dp[i][j] = (up+left);
            }
        }
        return dp[m-1][n-1];
    }
}