class Solution {
    public boolean isArraySpecial(int[] nums) {
        int n = nums.length;
        for(int i = 1; i < n ; i++){
            if(((nums[i]+nums[i-1])&1) == 0) return false;
        }
        return true;
    }
}