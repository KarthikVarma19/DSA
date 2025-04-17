class Solution {
    public int maxJump(int[] stones) {
        int mini = Math.abs(stones[0]-stones[1]);
        int n = stones.length;
        for(int i = 0; i < n; i++){
            if(i-2 >=0)
                mini = Math.max(mini, Math.abs(stones[i]-stones[i-2]));
        }
        return mini;
    }
}