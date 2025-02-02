class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int temp[] = Arrays.copyOf(nums, n);
        Arrays.sort(temp);
        for(int r = 0; r <= n; r++){
            boolean flag = true;
            for(int i = 0; i < n; i++){
                if(nums[i] != temp[(i + r) % n]){
                    flag = false;
                    break;
                }
            }
            if(flag == true) return true;
        }
        return false;
    }
}