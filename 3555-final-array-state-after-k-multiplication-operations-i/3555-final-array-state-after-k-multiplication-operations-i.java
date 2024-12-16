class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        while(k-- > 0){
            int minIndex = getMin(nums);
            nums[minIndex] *= multiplier;
        }
        return nums;
    }
    public int getMin(int nums[]){
        int minValue = nums[0], minIndex = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] < minValue){
                minValue = nums[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}