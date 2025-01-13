class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        int temp1[] = new int[n-1];
        int temp2[] = new int[n-1];
        int t1 = 0;
        for(int i=0;i<n;i++){
            if(i!=0){
                temp1[t1++] = nums[i];
            }
            if(i!=n-1){
                temp2[i] = nums[i];
            }
        }
        int ans1 = so(temp1);
        int ans2 = so(temp2);
        return Math.max(ans1, ans2);
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