class Solution {
    public int findChampion(int[][] grid) {
        int weaker[] = new int[grid.length];
        int count = 0;
        int champion = -1;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid.length;j++){
                if(grid[i][j] == 0 && i!=j){
                    weaker[i]++;
                }
            }
            if(weaker[i] == 0){
                count++;
                champion = i;
            }
        }
        return count==1?champion:-1;
    }
}