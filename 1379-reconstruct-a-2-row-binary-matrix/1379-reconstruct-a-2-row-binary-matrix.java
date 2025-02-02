class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<Integer>());
        ans.add(new ArrayList<Integer>());
        int setBits = 0;
        //First Giving Priority to 2colsum 
        for(int i = 0; i < colsum.length; i++)
        {
            ans.get(0).add(0);
            ans.get(1).add(0);
            if(colsum[i] == 2){
                colsum[i] = 0;
                lower -= 1;
                upper -= 1;
                ans.get(0).set(i, 1);
                ans.get(1).set(i, 1);
            }
            setBits += colsum[i];
            if((upper < 0) || (lower < 0)){
                List<List<Integer>> empty = new ArrayList<>();
                return empty;
            }
        }
        //Invalid Case
        if((upper + lower) != setBits)
        {
            List<List<Integer>> empty = new ArrayList<>();
            return empty;
        }
        //Traversing and filling Upper Row and then Lower Row
        for(int col = 0; col < colsum.length; col++){
            if(upper > 0 && colsum[col] > 0){
                ans.get(0).set(col, 1);
                colsum[col] -= 1;
                upper -= 1;
            }
            if(lower > 0 && colsum[col] > 0){
                ans.get(1).set(col, 1);
                colsum[col] -= 1;
                lower -= 1;
            }
        }
        return ans;
    }
}