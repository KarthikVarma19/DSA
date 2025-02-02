class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int inv = 0;
        for(int i = 1; i < n; i++){
            if(nums[i-1] > nums[i]){
                inv++;
            }
        }
        return (inv == 0 || (inv == 1 && nums[0] >= nums[n-1]));
    }
}