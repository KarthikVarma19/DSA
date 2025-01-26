class Solution {
    //In Space Optmization Code, Bottom-Up Approach Beats 100%
    //Time Complexity:- O(m + n) + O(m*n)
    //Space Complexity:- O(m * n)
    public int uniquePaths(int m, int n) {
        int dp[] = new int[n];
        for(int j = 0; j < n; j++){
            dp[j] = 1;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                int up = dp[j];
                int left = dp[j-1];
                dp[j] = up + left;
            }
        }
        return dp[n-1];
    }
}