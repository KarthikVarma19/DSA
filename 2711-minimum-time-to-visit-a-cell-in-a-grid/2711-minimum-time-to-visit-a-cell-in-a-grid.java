class Solution {
    class tuple{
        int time;
        int i;
        int j;
        tuple(int time,int i, int j){
            this.time = time;
            this.i = i;
            this.j = j;
        }
    }
    public int minimumTime(int[][] grid) {
        if(grid[0][1]>1 && grid[1][0]>1) return -1;
        //Initial Configuration for dijikstra's algorithm 
        int n = grid.length, m = grid[0].length;
        int visited[][] = new int[n][m];
        System.out.println(n + " " + m);
        //min-heap
        PriorityQueue<tuple> pq = new PriorityQueue<>((a,b) -> a.time - b.time);
        pq.add(new tuple(0,0,0));
        //Up,down,left,right;
        int directions[][] = {{0,1},{1,0},{-1,0},{0,-1}};
        while(!pq.isEmpty()){
            int time = pq.peek().time, i = pq.peek().i, j = pq.peek().j;
            pq.remove();
            if(visited[i][j] == 1) continue;
            visited[i][j] = 1;
            if(i == n-1 && j == m-1) return time;
            for(int eachSide[]: directions){
                int nrow = eachSide[0] + i, ncol = eachSide[1] + j;
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visited[nrow][ncol] == 0){
                    int waitTime = ((grid[nrow][ncol]-time) % 2 == 0)?1:0;
                    int nextTime = Math.max(grid[nrow][ncol] + waitTime, time+1);
                    pq.add(new tuple(nextTime,nrow,ncol));
                }
                
            }
        }
        //return -1 if not path is found to reach bottom-right cell
        return -1;
    }
}