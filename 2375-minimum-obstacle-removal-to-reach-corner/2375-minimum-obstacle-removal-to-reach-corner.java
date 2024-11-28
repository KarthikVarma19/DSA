class Solution {
    class pair{
        int obs;
        int i;
        int j;
        pair(int obs,int i, int j){
            this.obs = obs;
            this.i = i;
            this.j = j;
        }
    }
    public int minimumObstacles(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        //Initial Configuration for Dijikstra's Algorithm 
        PriorityQueue<pair> pq = new PriorityQueue<>((a,b) -> a.obs-b.obs);
        int dist[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j] = (int)(1e9);
            }
        }
        dist[0][0] = 0;
        pq.add(new pair(0,0,0));
        int dir[][] = {{0,1},{1,0},{-1,0},{0,-1}};
        //Until Min Heap is Empty 
        while(!pq.isEmpty()){
            int obs = pq.peek().obs, i = pq.peek().i, j = pq.peek().j;
            pq.remove();
            //As Min-Heap Top is Minimun if You Get Destination then you are at correct state and return it.
            if(i == n-1 && j == m-1) return dist[i][j];
            for(int each[]: dir){
                int nrow = each[0] + i, ncol = each[1] + j;
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m){
                    if((grid[nrow][ncol] + dist[i][j]) < dist[nrow][ncol]){
                        dist[nrow][ncol] = grid[nrow][ncol] + dist[i][j];
                        pq.add(new pair(grid[nrow][ncol] + dist[i][j],nrow,ncol));
                    }
                }
            }
        }
        return dist[n-1][m-1];
    }
}