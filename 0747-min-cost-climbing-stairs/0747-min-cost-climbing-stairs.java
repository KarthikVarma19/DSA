class Solution {
    public int minCostClimbingStairs(int[] cost) {
        return sop(cost);
    }
    public static int sop(int cost[]){
        int n = cost.length;
        int ahead1 = 1000;
        int ahead = 0;
        for(int i = n-1; i>=0;i--){
            int oneStep = cost[i] + ahead;
            int twoStep = 1000;
            if(i+2 <= n){
               twoStep = cost[i] + ahead1; 
            } 
            int curi = Math.min(oneStep, twoStep); 
            ahead1 = ahead;
            ahead = curi;
        }
        return Math.min(ahead1, ahead);
    }
}