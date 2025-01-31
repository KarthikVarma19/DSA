class Solution {
    int n;
    public boolean canCross(int[] stones) {
        n = stones.length;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0; i < stones.length; i++){
            hm.put(stones[i], i);
        }
        int dp[][] = new int[2001][2001];
        for(int row[]: dp){
            Arrays.fill(row, -1);
        }
        return f(0, 0, hm, stones, dp); 

    }
    public boolean f(int curStoneIndex, int prevJump, HashMap<Integer,Integer> hm , int stones[], int dp[][]){
        if(curStoneIndex == n-1) return true;
        if(dp[curStoneIndex][prevJump] != -1){
            return dp[curStoneIndex][prevJump] == 1;
        }
        boolean result = false;
        for(int nextJump = prevJump-1; nextJump <= prevJump+1; nextJump++){
            if(nextJump > 0){
                int nextStone = stones[curStoneIndex] + nextJump;
                if(hm.containsKey(nextStone) == true){
                    int nextStoneIndex = hm.get(nextStone);
                    result = result | f(nextStoneIndex, nextJump, hm, stones, dp);
                }
            }
        }
        if(result == true){
            dp[curStoneIndex][prevJump] =  1;
            return true;
        }
        dp[curStoneIndex][prevJump] = 0;
        return false;
    }
}