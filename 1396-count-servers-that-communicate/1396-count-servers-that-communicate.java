class Solution {
    public int countServers(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        //col check
        int preCol[] = new int[m];
        for(int j = 0; j < m; j++){
            for(int i = 0; i < n; i++){
                preCol[j] += grid[i][j];
            }
        }

        int count = 0;

        int pre[] = new int[n];
        //row check 
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                pre[i] += grid[i][j];
            }
            for(int j = 0; j < m ; j++){
                if(grid[i][j] == 1 && Math.max(pre[i], preCol[j]) > 1){
                    count++;
                }
            }
        }


        return count;
       
        //TC:- O(n*m) + O(n*m) + O(n*m)
    }
}