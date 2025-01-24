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

}