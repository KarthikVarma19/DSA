class Solution {
    public int countServers(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int pre[] = new int[n];
        //row check 
        for(int i = 0; i < n; i++){
            for(int j = 0; j < grid[i].length; j++){
                pre[i] += grid[i][j];
            }
        }
        int canCommunicate = 0;
        //col check 
        int preCol[] = new int[m];
        for(int j = 0; j < m; j++){
            for(int i = 0; i < n; i++){
                preCol[j] += grid[i][j];
            }
        }

        int count = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m ; j++){
                if(grid[i][j] == 1){
                    if(Math.max(pre[i], preCol[j]) > 1) count++;
                }
            }
        }

        return count;
    }
}