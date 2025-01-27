class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int dp[][] = new int[m][n];
        // filling row
        for(int i = 0; i < n; i++){
            dp[0][i] = matrix[0][i];
        }
        //filling column 
        for(int j = 0; j < m; j++){
            dp[j][0] = matrix[j][0];
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][j] == 1){
                    dp[i][j] = Math.min(dp[i][j-1], Math.min(dp[i-1][j-1], dp[i-1][j])) + 1;
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }
        int countSquares = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                countSquares += dp[i][j];
            }
        }
        return countSquares;
    }
}