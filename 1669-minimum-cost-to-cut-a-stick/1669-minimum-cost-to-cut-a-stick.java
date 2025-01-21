class Solution {
    public int minCost(int n, int[] cuts) {
        int c = cuts.length;
        int temp[] = new int[c+2];
        temp[0] = 0;
        for(int i = 0; i < c; i++){
            temp[i+1] = cuts[i];
        }
        temp[c+1] = n;
        Arrays.sort(temp);
        int dp[][] = new int[c+2][c+2];
        for(int i = c; i >= 1; i--){
            for(int j = 1; j <= c; j++){
                if(i>j) continue;
                int mini = Integer.MAX_VALUE;
                for(int ind = i; ind <= j; ind++){
                    int cost = temp[j+1] - temp[i-1] + dp[i][ind-1] + dp[ind+1][j];
                    if(cost < mini){
                        mini = cost;
                    }
                }
                dp[i][j] = mini;
            }
        }
        return dp[1][c];
    }
    
}