class Solution {
    public int maxJump(int[] stones) {
        int mini = Math.abs(stones[0]-stones[1]);
        int n = stones.length;
        for(int i = 2; i < n; i+=2){
            mini = Math.max(mini, Math.abs(stones[i]-stones[i-2]));
        }
        for(int i = 3; i < n; i+=2){
            mini = Math.max(mini, Math.abs(stones[i]-stones[i-2]));
        }
        return mini;
    }
}