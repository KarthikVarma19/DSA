class Solution {
    public int[] buildArray(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++){
            // doing % mod since somebody might modified it 
            int modified = 1000 * (nums[nums[i]] % 1000);
            // previous value plus our 1000 based original value
            nums[i] += modified;
        }
        for(int i = 0; i < n; i++){
            nums[i] = nums[i]/1000;
        }
        return nums;
    }
}