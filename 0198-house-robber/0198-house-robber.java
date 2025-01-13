class Solution {

    public int rob(int[] nums) {
        int n = nums.length;
        return so(nums);
    }

    public int so(int[] nums){
        int n = nums.length;
        int prev2 = 0;
        int prev = nums[0];
        for(int i=1;i<n;i++){
            int pick = nums[i];
            if(i>1){
                pick += prev2;
            }
            int notpick = prev;

            int curi = Math.max(pick, notpick);
            prev2 = prev;
            prev = curi;

        }
        return prev;
    }
}