class Solution {
    //In Memoization Solution, 
    //Time Complexity:- O(m * n)
    //Space Complexity:- O(m * n)
    int modulo = (int)((1e9) + 7);
    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][][] = new int[m][n][k];
        for(int row[][]: dp){
            for(int b[]: row){
                Arrays.fill(b, -1);
            }
        }
        return f(m-1, n-1, grid, k, 0, dp);
    }
    public int f(int i, int j, int grid[][], int k, int sum, int dp[][][]){
        if(i == 0 && j == 0){
            if((sum + grid[i][j]) % k == 0) return 1;
            return 0; 
        }
        if(i < 0 || j < 0){
            return 0;
        }
        int mod = sum % k;
        if(dp[i][j][mod] != -1) return dp[i][j][mod];
        sum += grid[i][j];
        int up = f(i-1, j, grid, k, sum, dp);
        int left = f(i, j-1, grid, k, sum, dp);
        return dp[i][j][mod] = (up + left)%modulo;
    }
}