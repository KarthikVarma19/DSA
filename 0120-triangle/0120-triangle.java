class Solution {
    //Memoization
    public int minimumTotal(List<List<Integer>> t) {
        int n = t.size();
        int m = t.get(n-1).size();
        int dp[][] = new int[m][n];
        for(int row[]: dp){
            Arrays.fill(row, -1);
        }
        return f(0, 0, t, dp);
    }
    public int f(int ind, int row, List<List<Integer>> t, int dp[][]){
        if(row == t.size()-1){
            return t.get(row).get(ind);
        }

        if(dp[ind][row] != -1) return dp[ind][row];

        int choice2 = f(ind+1, row+1, t, dp);
        int choice1 = f(ind, row+1, t, dp);
        
        int val = t.get(row).get(ind);

        return dp[ind][row] = Math.min(choice1 , choice2) + val;
    }
}