class Solution {
    public int[][] specialGrid(int N) {
        System.out.println(N);
        int quad = (1 << N);
        int ans[][] = new int[quad][quad];
        int start = 0;
        int end = (1 << (1 << N));
        solve(ans, 0,quad, 0,quad, start);
        return ans;
    }
    public void solve(int ans[][], int rs, int re, int cs, int ce, int start){
        if(re - rs == 1 && ce - cs == 1){
            ans[rs][cs] = start;
            return;
        }
        int cmid = (ce + cs) /2;
        int rmid = (re + rs)/2;
        int div = (re - rs) * (ce - cs) / 4;

        // 2nd
        solve(ans, rs, rmid, cmid, ce, start);
        // 4rth
        solve(ans, rmid, re, cmid, ce, start + div);
        // 3rd
        solve(ans, rmid, re, cs, cmid, start + (2 * div));
        // 1st quad
        solve(ans, rs, rmid, cs, cmid, start + (3 * div));
    }
}