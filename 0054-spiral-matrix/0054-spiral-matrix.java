class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int n = matrix.length, m = matrix[0].length;
        int rs = 0, re = n-1, cs = 0, ce = m-1;
        while(rs <= re && cs <= ce){
            for(int i = cs; i <= ce; i++){
                ans.add(matrix[rs][i]);
            }
            rs++;
            for(int j = rs; j <= re; j++){
                ans.add(matrix[j][ce]);
            }
            ce--;
            if(rs <= re){
                for(int i = ce; i >= cs; i--){
                    ans.add(matrix[re][i]);
                }
                re--;
            }
            if(cs <= ce){
                for(int j = re; j >= rs; j--){
                    ans.add(matrix[j][cs]);
                }
                cs++;
            }
        }
        return ans;
    }
}