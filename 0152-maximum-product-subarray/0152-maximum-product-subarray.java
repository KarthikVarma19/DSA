class Solution {
    public int maxProduct(int[] nums) {
        int ans = nums[0];
        int mini = nums[0];
        int maxi = nums[0];
        for(int i = 1; i < nums.length; i++){
            int ele = nums[i];
            int temp = Math.max(ele, Math.max(ele * maxi, ele * mini));
            mini = Math.min(ele, Math.min(ele * maxi, ele * mini));
            maxi = temp;
            ans = Math.max(ans, maxi);
        }
        return ans;
    }
}