class Solution {
    public int countSubarrays(int[] nums) {
        int count = 0;
        for(int i=0;i<=nums.length-3;i++){
            double lhs = nums[i+1]/2.0;
            double rhs = nums[i] + nums[i+2];
            if(lhs == rhs) count++;
        }
        return count;
    }
}