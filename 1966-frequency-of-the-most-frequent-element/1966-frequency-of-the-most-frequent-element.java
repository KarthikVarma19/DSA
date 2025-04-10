class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0, j = 0, n = nums.length;
        long curSum = 0;
        int ans = 1;
        while(j < n){
            //if greater than k operaions shrink the window
            long cur = (long)nums[j];
            curSum += cur;
            while(((long)(nums[j]*(long)(j-i+1))-curSum) > k){
                curSum -= (long)nums[i];
                i++;
            }
            ans = Math.max(ans, (j-i+1));
            j++;
        }
        return ans;
    }
}