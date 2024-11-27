class Solution {
    class pair{
        int distance;
        int i;
        int j;
        pair(int distance,int i,int j){
            this.distance = distance;
            this.i = i;
            this.j = j;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int distance[][] = new int[n][n];
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        PriorityQueue<pair> q = new PriorityQueue<>((a,b) -> a.distance-b.distance);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                distance[i][j] = (int)(1e9);
            }
        }
        distance[0][0] = 0;
        q.add(new pair(0,0,0));
        while(!q.isEmpty()){
            int curDis = q.peek().distance;
            int i = q.peek().i;
            int j = q.peek().j;
            q.remove();
            for(int a=-1;a<=1;a++){
                for(int b=-1;b<=1;b++){
                    int nrow = i + a;
                    int ncol = j + b;
                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<n && grid[nrow][ncol] == 0 && curDis+1 < distance[nrow][ncol]){
                        q.add(new pair(curDis+1,nrow,ncol));
                        distance[nrow][ncol] = curDis+1;
                        if(nrow == n-1 && ncol == n-1) return curDis+2;
                    }
                }
            }
        }
        if(0 == n-1) return 1;
        return -1;
    }
}