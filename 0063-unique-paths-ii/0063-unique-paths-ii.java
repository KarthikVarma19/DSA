class Solution {
    //In, Space Optimization Solution. It Beats 100%
    //Time Complexity:- O(m*n)
    //Spac Complexity:- O(n)
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(grid[0][0] == 1) return 0;
        int dp[] = new int[n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    dp[j] = 0;
                    continue;
                }
                else if(i == 0 && j == 0){
                    dp[j] = 1;
                    continue;
                }
                int up = 0, left = 0;
                if(i-1 >= 0){
                    up = dp[j];
                }
                if(j-1 >= 0){
                    left = dp[j-1];
                }
                dp[j] = (up+left);
            }
        }
        return dp[n-1];
    }
}