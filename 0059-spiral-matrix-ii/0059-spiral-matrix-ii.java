class Solution {
    public int[][] generateMatrix(int n) {
        int value = 0;
        int ans[][] = new int[n][n];
        int rs = 0, re = n-1, cs = 0, ce = n-1;
        while(rs <= re && cs <= ce){
            for(int i = cs; i <= ce; i++){
                ans[rs][i] = ++value;
            }
            rs++;
            for(int j = rs; j <= re; j++){
                ans[j][ce] = ++value;
            }
            ce--;
            if(rs <= re){
                for(int i = ce; i >= cs; i--){
                    ans[re][i] = ++value;
                }
                re--;
            }
            if(cs <= ce){
                for(int j = re; j >= rs; j--){
                    ans[j][cs] = ++value;
                }
                cs++;
            }
        }
        return ans;
    }
}