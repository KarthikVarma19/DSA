class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // each index can be converted into the row, col
        int n = matrix.length;
        int m = matrix[0].length;
        int low = 0; 
        int high = n * m - 1;
        boolean found = false;
        while(low <= high){
            int mid = (low + high) >>> 1;
            int row = mid/m;
            int col = mid%m;
            int element = matrix[row][col];
            if(element == target){
                found =  true;
                break;
            }
            else if(element < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return found;
    }
}