class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = 0;
        for(int num: nums){
            if(len == 0 || nums[len-1] < num){
                nums[len++] = num;
            }
            else{
                int pos = Arrays.binarySearch(nums, 0, len, num);
                if(pos < 0){
                    pos = -pos-1;
                }
                nums[pos] = num;
            }
        }   
        return len;
    }
}