class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        int nums1[] = new int[n-1];
        int nums2[] = new int[n-1];
        for(int i = 0; i < n; i++){
            if(i!=0){
                nums1[i-1] = nums[i];
            }
            if(i!=n-1){
                nums2[i] = nums[i];
            }
        }
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        int rob1 = f(n-2,nums1, dp);
        Arrays.fill(dp, -1);
        int rob2 = f(n-2,nums2, dp);
        return Math.max(rob1, rob2);
    }
    public int f(int n, int a[], int dp[]){
        int prev2 = 0;
        int prev = a[0];
        for(int ind = 1; ind <= n; ind++){
            int take = a[ind];
            if(ind > 1){
                take += prev2;
            } 
            int notTake = 0 + prev;
            int curi = Math.max(take, notTake);
            prev2 = prev;
            prev = curi;
        }
        return prev;
    }
/* 
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        int nums1[] = new int[n-1];
        int nums2[] = new int[n-1];
        for(int i = 0; i < n; i++){
            if(i!=0){
                nums1[i-1] = nums[i];
            }
            if(i!=n-1){
                nums2[i] = nums[i];
            }
        }
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        int rob1 = f(n-2,nums1, dp);
        Arrays.fill(dp, -1);
        int rob2 = f(n-2,nums2, dp);
        return Math.max(rob1, rob2);
    }
    public int f(int n, int a[], int dp[]){
        dp[0] = a[0];
        for(int ind = 1; ind <= n; ind++){
            int take = a[ind];
            if(ind > 1){
                take += dp[ind-2];
            } 
            int notTake = 0 + dp[ind-1];
            dp[ind] = Math.max(take, notTake);
        }
        return dp[n];
    }
*/
    //Memoization Code
    /*public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        int nums1[] = new int[n-1];
        int nums2[] = new int[n-1];
        for(int i = 0; i < n; i++){
            if(i!=0){
                nums1[i-1] = nums[i];
            }
            if(i!=n-1){
                nums2[i] = nums[i];
            }
        }
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        int rob1 = f(n-2,nums1, dp);
        Arrays.fill(dp, -1);
        int rob2 = f(n-2,nums2, dp);
        return Math.max(rob1, rob2);
    }
    public int f(int ind, int a[], int dp[]){
        if(ind == 0){
            return a[0];
        }
        if(ind < 1){
            return 0;
        }
        if(dp[ind] != -1){
            return dp[ind];
        }
        int take = a[ind] + f(ind-2, a, dp);
        int notTake = 0 + f(ind-1, a, dp);
        return dp[ind] = Math.max(take, notTake);
    }
    */

    //Recursive Code

    /*
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        int nums1[] = new int[n-1];
        int nums2[] = new int[n-1];
        for(int i = 0; i < n; i++){
            if(i!=0){
                nums1[i-1] = nums[i];
            }
            if(i!=n-1){
                nums2[i] = nums[i];
            }
        }
        int rob1 = f(n-2,nums1);
        int rob2 = f(n-2,nums2);
        return Math.max(rob1, rob2);
    }
    public int f(int ind, int a[]){
        if(ind == 0){
            return a[0];
        }
        if(ind < 1){
            return 0;
        }
        int take = a[ind] + f(ind-2, a);
        int notTake = 0 + f(ind-1, a);
        return Math.max(take, notTake);
    }
    */
}