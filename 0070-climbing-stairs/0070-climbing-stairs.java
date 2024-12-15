class Solution {
    public int climbStairs(int n) {
        int prev2 = 1, prev = 1;
        for(int i=2;i<=n;i++){
            int curi = prev + prev2;
            prev2 = prev;
            prev = curi;
        }
        return prev;
    }
}