class Solution {
    public boolean check(int[] nums) {
        int excuses = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i-1] > nums[i]){
                excuses += 1;
            }
        }   
        if(excuses == 1 && nums[0] >= nums[nums.length-1] || excuses == 0) return true;
        return false;
    }
}