class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        for(int i=0;i<m;i++){
            int rStart = 0, rEnd = n-1;
            if(matrix[i][rEnd] < target){
                continue;
            }
            while(rStart <= rEnd){
                int mid = rStart + (rEnd-rStart)/2;
                if(matrix[i][mid] == target) return true;
                else if(matrix[i][mid] > target){
                    rEnd = mid-1;
                }
                else{
                    rStart = mid + 1;
                }
            }
            return false;
        }
        return false;
    }
}