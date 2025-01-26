class Solution {
    //In Tabulation Solution, It Beats 99%
    //Time Complexity:- O((m*n) 
    //Space Complexity:-  O(m*n)
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0){
                    dp[i][j] = grid[i][j];
                    continue;
                }
                int up = (int)1e7;
                if(i > 0){
                    up = dp[i-1][j];
                }
                int left = (int)1e7;
                if(j > 0){
                    left = dp[i][j-1];
                }
                dp[i][j] = (Math.min(up, left) + grid[i][j]);
            }
        }
        return dp[m-1][n-1];   
    }
}