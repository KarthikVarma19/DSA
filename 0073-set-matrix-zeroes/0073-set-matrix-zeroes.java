class Solution {
    public void setZeroes(int[][] matrix) {
        int temp = 1;
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0;j < m; j++){
                if(matrix[i][j] != 0) continue;
                // if first column has zero set the temp as 0
                if(j == 0){
                    temp = 0;
                }
                // if any thing has zero set it's column and row's first index to 0
                else{
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Start from (1,1,) to (n-1, m-1)
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        // if (0, 0) is zero make the first row to zero 
        if(matrix[0][0] == 0){
            for(int j = 0; j < m; j++){
                matrix[0][j] = 0;
            }
        }
        
        // if temp is zero make the first column to zero 
        if(temp == 0){
            for(int i = 0; i < n; i++){
                matrix[i][0] = 0;
            }
        }
    }
}