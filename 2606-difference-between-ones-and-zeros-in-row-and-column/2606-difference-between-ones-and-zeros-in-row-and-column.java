class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans[][] = new int[n][m];
        int rowOnes[] = new int[n];
        int colOnes[] = new int[m];
        
        //traversing row wise 
        for(int i = 0; i < n; i++){
            int ones = 0;
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    ones++;
                }
            }
            rowOnes[i] = ones;
        }

        //traversing col wise 
        for(int j = 0; j < m; j++){
            int ones = 0;
            for(int i = 0; i < n; i++){
                if(grid[i][j] == 1){
                    ones++;
                }
            }
            colOnes[j] = ones;
        }
        //filling the answer 
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                ans[i][j] = rowOnes[i] + colOnes[j] -(m-rowOnes[i]) - (n-colOnes[j]);
            }
        }
        return ans;
    }
}