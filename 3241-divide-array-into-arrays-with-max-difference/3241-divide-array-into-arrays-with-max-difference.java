class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans[][] = new int[n/3][3];
        for(int i = 0; i < nums.length; i+= 3){
            ans[i/3][i%3] = nums[i];
            ans[i/3][(i+1)%3] = nums[i+1];
            ans[i/3][(i+2)%3] = nums[i+2];
            if(Math.abs(ans[i/3][0]-ans[i/3][2]) > k){
                return new int[0][0];
            }
        }
        return ans;
    }
}