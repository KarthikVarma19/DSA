class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0, n = nums.length, j = 0;
        int count = 0;
        while(i < n && j < n){
            if(Math.abs(nums[i]-nums[j]) > k){
                count += 1;
                i = j;
            }
            j++;
        }
        return count + 1;
    }
}