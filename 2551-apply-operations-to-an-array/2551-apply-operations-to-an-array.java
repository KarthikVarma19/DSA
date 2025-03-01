class Solution {
    public int[] applyOperations(int[] nums) {
        //Applying the Given Operation
        int n = nums.length;
        int ans[] = new int[n];
        int ap = 0;
        for(int i = 0; i < n; i++){
            if(i < n-1 && nums[i] == nums[i+1]){
                nums[i] *= 2;
                nums[i+1] = 0;
            }
            if(nums[i] != 0){
                ans[ap++] = nums[i];
            }
        }
        return ans;
    }
}