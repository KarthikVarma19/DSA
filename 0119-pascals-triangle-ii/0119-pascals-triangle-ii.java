class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i <= rowIndex; i++){
            ans.add(nCr(rowIndex, i));
        }
        return ans;
    }
    private int nCr(int n, int r){
        long res = 1;
        for(int i = 0; i < r; i++){
            res *= (n-i);
            res /= (i+1);
        }
        return (int)res;
    }
}