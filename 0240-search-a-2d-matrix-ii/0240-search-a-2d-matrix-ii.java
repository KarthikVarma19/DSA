class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int i = 0;
        int j = m - 1;
        boolean found = false;
        while(i < n && j >= 0){
            int element = matrix[i][j];
            if(element == target){
                found = true;
                break;
            }
            else if(element < target){
                i++;
            }
            else if(element > target){
                j--;
            }
        }
        return found;
    }
}