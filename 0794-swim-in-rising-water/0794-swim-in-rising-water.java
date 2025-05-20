class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] c1, int[] c2){
                return Integer.compare(c1[0], c2[0]);
            }
        });
        int cr[] = {-1, 0, 1, 0,};
        int cc[] = {0, 1, 0, -1};
        boolean[][] vis = new boolean[n][n];
        pq.add(new int[]{grid[0][0], 0, 0});
        vis[0][0] = true;
        while(!pq.isEmpty()){
            int tp[] = pq.remove();
            if(tp[1] == n-1 && tp[2] == n-1){
                return tp[0];
            }
            for(int k = 0; k < 4; k++){
                int ni = tp[1] + cr[k], nj = tp[2] + cc[k];
                if(ni >= 0 && ni < n && nj >= 0 && nj < n && vis[ni][nj] == false){
                    pq.add(new int[]{Math.max(tp[0], grid[ni][nj]), ni, nj});
                    vis[ni][nj] = true;
                }
            }
        }

        return -1;
    }
}