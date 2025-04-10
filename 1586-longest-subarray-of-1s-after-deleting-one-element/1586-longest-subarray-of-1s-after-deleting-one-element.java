class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int left = 0, right = 0;
        int countz= 0;
        while(right < n){
            if(nums[right] == 0){
                countz++;
            }
            if(countz > 1){
                if(nums[left] == 0){
                    countz--;
                }
                left++;
            }
            // if(countz <= 1)
            //     ans = Math.max(ans, (right - left + 1));
            right++;
        }
        // since i must delete one element 
        return n-left-1;
    }
}