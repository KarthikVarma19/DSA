class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long leftSum = 0, rightSum = 0;

        for(int num: nums){
            rightSum += num;
        }
        int ways = 0;
        for(int i=0;i<n-1;i++){
            leftSum += nums[i];
            rightSum -= nums[i];
            if(leftSum >= rightSum) ways++;
        }
        return ways;
    }
}