class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int prefix = 1;
        int suffix = 1;
        int ans = nums[0];
        for(int i = 0; i < n; i++){
            int first = nums[i], last = nums[n-i-1];
            if(prefix == 0) prefix = 1;
            if(suffix == 0) suffix = 1;
            prefix *= first;
            suffix *= last;
            ans = Math.max(ans, Math.max(prefix, suffix));
        }
        return ans;
    }
}