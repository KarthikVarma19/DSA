class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int n = colsum.length;
        int mat[][] = new int[2][n];
        for(int i = 0; i < n; i++)
        {
            if(colsum[i] == 0)
                continue;
            else if(colsum[i] == 2)
            {
                lower -= 1;
                upper -= 1;
                mat[0][i] = 1;
                mat[1][i] = 1;
            }
            else if(upper > lower)
            {
                mat[0][i] = 1;
                upper -= 1;
            }
            else{
                mat[1][i] = 1;
                lower -= 1;
            }
        }
        if(upper != 0 || lower != 0){
            return new ArrayList<>();
        }
        return new ArrayList(Arrays.asList(mat[0], mat[1]));
    }
}