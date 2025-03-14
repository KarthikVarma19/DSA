class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int low = 0, high = m - 1;
        while(low<=high){
            int mid = (low + high) >>> 1;
            int max_in_cols_row = findMaxElementInCol(mat, mid);
            int left = mid-1>=0?mat[max_in_cols_row][mid-1]:-1;
            int right = mid+1<=m-1?mat[max_in_cols_row][mid+1]:-1;
            int cur = mat[max_in_cols_row][mid];
            if(cur > left && cur > right){
                return new int[]{max_in_cols_row, mid};
            }
            else if(left > cur){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return new int[]{-1, -1};
    }
    public int findMaxElementInCol(int mat[][], int col){
        int max = mat[0][col];
        int max_row_index = 0;
        for(int i = 0; i < mat.length; i++){
            int cur = mat[i][col];
            if(cur > max){
                max = cur;
                max_row_index = i;
            }
        }
        return max_row_index;
    }
}