class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int dp[] = new int[n+1];
        for(int ind = n-1; ind >=0; ind--){
            int len = 0; 
            int maxi = 0;
            int maxAns = 0;
            for(int i = ind; i < Math.min(ind + k, n); i++){
                len++;
                maxi = Math.max(maxi, arr[i]);
                int sum = (len * maxi) + dp[i+1];
                maxAns = Math.max(maxAns, sum);
            }
            dp[ind] = maxAns;
        }
        return dp[0];
    }


    /*
    //Memoization Solution Beats 95% Let's Make it Still Better
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        return f(0, arr, k, dp);
    }

    public int f(int ind, int arr[], int k, int dp[]){
        int n = arr.length;
        if(ind == n) return 0;
        if(dp[ind] != -1) return dp[ind];
        int len = 0; 
        int maxi = 0;
        int maxAns = 0;
        for(int i = ind; i < Math.min(ind + k, n); i++){
            len++;
            maxi = Math.max(maxi, arr[i]);
            int sum = (len * maxi) + f(i+1, arr, k, dp);
            maxAns = Math.max(maxAns, sum);
        }
        return dp[ind] = maxAns;
    }

    */
    /*
    //Recursive Solution Got TLE at 14/52 Let's Memoize it.
    public int maxSumAfterPartitioning(int[] arr, int k) {
        return f(0, arr, k);
    }

    public int f(int ind, int arr[], int k){
        int n = arr.length;
        if(ind == n) return 0;
        int len = 0; 
        int maxi = 0;
        int maxAns = 0;
        for(int i = ind; i < Math.min(ind + k, n); i++){
            len++;
            maxi = Math.max(maxi, arr[i]);
            int sum = (len * maxi) + f(i+1, arr, k);
            maxAns = Math.max(maxAns, sum);
        }
        return maxAns;
    }
    */
}