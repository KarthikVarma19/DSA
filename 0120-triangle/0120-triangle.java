class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m = triangle.get(n-1).size();
        int dp[][] = new int[n][m];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(0, 0, triangle, dp);
    }
    public int solve(int ind, int row, List<List<Integer>> triangle, int dp[][]){
        if(row == triangle.size()-1){
            return dp[ind][row] = triangle.get(row).get(ind);
        }
        if(dp[ind][row] != -1){
            return dp[ind][row];
        }
        int curValue = triangle.get(row).get(ind);
        int choice1 = solve(ind, row+1, triangle, dp);
        int choice2 = solve(ind+1, row+1, triangle, dp);
        return dp[ind][row] =  (curValue + Math.min(choice1, choice2));
    }
}