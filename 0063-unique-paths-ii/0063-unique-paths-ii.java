class Solution {
    //In, Memoization Solution. I Got TLE at 31/42 testcases passed 
    //Time Complexity:- O(m*n)
    //Spac Complexity:- O(m+n) + O(m*n)
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(grid[0][0] == 1) return 0;
        int dp[][] = new int[m][n];
        for(int row[]: dp){
            Arrays.fill(row, -1);
        }
        return f(m-1, n-1, grid, dp);
    }
    public int f(int i, int j, int grid[][], int dp[][]){
        if(i == 0 && j == 0){
            return 1;
        }
        if(i < 0 || j < 0 || grid[i][j] == 1){
            return 0;
        }
        if(dp[i][j] != -1) return dp[i][j];
        int up = f(i-1, j, grid, dp);
        int left = f(i, j-1, grid, dp);
        return dp[i][j] = (up+left);
    }
}