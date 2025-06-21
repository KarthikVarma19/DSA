class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        int scoreWithIndex[][] = new int[n][2];
        for(int i = 0; i < n; i++){
            scoreWithIndex[i][0] = score[i];//score
            scoreWithIndex[i][1] = i;//index
        }
        // sort 
        Arrays.sort(scoreWithIndex, new Comparator<int[]>(){
            public int compare(int a[], int b[]){
                return b[0] - a[0];
            }
        });
        
        String ans[] = new String[n];
        
        for(int i = 0; i < Math.min(3, n); i++){
            if(i == 0){
                ans[scoreWithIndex[0][1]] = "Gold Medal";
            } else if(i == 1){
                ans[scoreWithIndex[1][1]] = "Silver Medal";
            }else {
                ans[scoreWithIndex[2][1]] = "Bronze Medal";
            }
        }
        
        for(int i = 3; i < n; i++){
            ans[scoreWithIndex[i][1]] = "" + (i + 1);
        }
        return ans;
        
    }
}