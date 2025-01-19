class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int counter = 1;
        int maxCounter = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i-1] < nums[i]){
                counter++;
                if(maxCounter < counter){
                    maxCounter = counter;
                }
            }
            else{
                counter =  1;
            }
        }
        return maxCounter;
    }
}