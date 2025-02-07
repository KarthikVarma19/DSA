class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;
        HashMap<Integer,Integer> colorCount = new HashMap<>();
        HashMap<Integer,Integer> ballColor = new HashMap<>();
        int ans[] = new int[n];
        for(int i = 0; i < n; i++){
            int x = queries[i][0], y = queries[i][1];
            if(ballColor.containsKey(x)){
                int prevColor = ballColor.get(x);
                //ballColor.put(x, y);
                int prevColorCount = colorCount.get(prevColor);
                if(prevColorCount == 1){
                    colorCount.remove(prevColor);
                }
                else{
                    colorCount.put(prevColor, colorCount.get(prevColor) - 1);
                }
            }
            ballColor.put(x, y);
            colorCount.put(y, colorCount.getOrDefault(y, 0) + 1);
            ans[i] = colorCount.size();
        }
        return ans;
    }
}