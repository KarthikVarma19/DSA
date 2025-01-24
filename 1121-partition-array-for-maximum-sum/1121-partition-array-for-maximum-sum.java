class Solution {
    //Memoization Solution
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
}