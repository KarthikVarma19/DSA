class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int ans[] = new int[n];
        int ptr = 0;
        int pivotCount = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] < pivot){
                ans[ptr++] = nums[i];
            }else if(nums[i] == pivot){
                pivotCount++;
            }
        }
        while(pivotCount > 0){
            ans[ptr++] = pivot;
            pivotCount--;
        }
        for(int i = 0; i < n; i++){
            if(nums[i] > pivot){
                ans[ptr++] = nums[i];
            }
        }
        return ans;
    }
}