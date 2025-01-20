class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans[][] = new int[n][m];
        int rowOnes[] = new int[n];
        int colOnes[] = new int[m];

        //traversing col wise but computing both rowOnes and colOnes in one for loop 
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                rowOnes[i] += grid[i][j];
                colOnes[j] += grid[i][j];
            }
        }

        //computing the answer 
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                ans[i][j] = rowOnes[i] + colOnes[j] -(m-rowOnes[i]) - (n-colOnes[j]);
            }
        }

        return ans;
    }
}