class Solution {
    //In Space Optmization Code, Bottom-Up Approach Beats 100%
    //Time Complexity:- O(n) + O(m*n)
    //Space Complexity:- O(n)
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


    /*In Memoization Solution, It Beats 100% 
    Limitation is Auxilary Stack Space it uses 
    Time Complexity:- O(m*n)
    Space Complexity:- O(m*n) + O(m+n)
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for(int each[]: dp){
            Arrays.fill(each, -1);
        }
        return f(m-1, n-1, dp);
    }

    public int f(int i, int j, int dp[][]){
        if(i == 0 && j == 0){
            return 1;
        }
        if(i<0 || j<0){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int up = f(i-1, j, dp);
        int left = f(i, j-1, dp);
        return dp[i][j] = up + left;
    }
    */


    /*
    //In, Recursive Solution Got TLE at 38/63 testcases passed
    //Time Complexity:- O(2^(m+n))
    //Space Complexity:- O(m+n)
    public int uniquePaths(int m, int n) {
        return f(m-1, n-1);
    }

    public int f(int i, int j){
        if(i == 0 && j == 0){
            return 1;
        }
        if(i<0 || j<0){
            return 0;
        }

        int up = f(i-1, j);
        int left = f(i, j-1);
        return up + left;
    }
    */
}