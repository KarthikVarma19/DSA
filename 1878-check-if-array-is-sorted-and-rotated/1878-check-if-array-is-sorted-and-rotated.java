class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int temp[] = new int[n];
        for(int r = 0; r <= n; r++){
            int idx = 0;
            for(int i = r; i < n; i++){
                temp[idx++] = nums[i];
            }
            for(int i = 0; i < r; i++){
                temp[idx++] = nums[i];
            }
            if(checkSorted(temp) == true) return true;
        }
        return false;
    }
    public boolean checkSorted(int nums[]){
        for(int i = 1; i < nums.length; i++){
            if(nums[i-1] > nums[i]){
                return false;
            }
        }
        return true;
    }
}