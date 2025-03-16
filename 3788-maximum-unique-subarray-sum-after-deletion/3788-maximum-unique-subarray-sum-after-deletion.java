class Solution {
    public int maxSum(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int n = nums.length;
        HashSet<Integer> hs = new HashSet<>();
        int totSum = 0;
        for(int i = 0; i < n; i++){
            maxSum = Math.max(maxSum, nums[i]);
            if(nums[i] > 0 && !hs.contains(nums[i])){
                hs.add(nums[i]);
                totSum += nums[i];
            }
        }
        if(maxSum < 0) return maxSum;
        return totSum;
    }
}