class Solution {
    
    public int f(int index, int nums[], int dp[]){
        if(index == 0){
            return nums[index];
        }
        if(index < 0){
            return 0;
        }
        if(dp[index] != -1){
            return dp[index];
        }
        int pick = nums[index] + f(index-2, nums, dp);
        int notpick = 0 + f(index-1, nums, dp);
        return dp[index] = Math.max(pick, notpick);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        //return f(n-1, nums, dp);
        return t(nums, dp);
    }

    public int t(int[] nums, int dp[]){
        int n = nums.length;
        dp[0] = nums[0];
        int neg = 0;
        for(int i=1;i<n;i++){
            int pick = nums[i];
            if(i>1){
                pick += dp[i-2];
            }
            int notpick = dp[i-1];

            dp[i] = Math.max(pick, notpick);
        }
        return dp[n-1];
    }
}