class Solution {
    class pair{
        int diff;
        int i;
        int j;
        pair(int diff,int i,int j){
            this.diff = diff;
            this.i = i;
            this.j = j;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length, m = heights[0].length;
        int distance[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                distance[i][j] = (int)(1e9);
            }
        }
        int directions[][] = {{0,1},{0,-1},{1,0},{-1,0}};
        PriorityQueue<pair> pq = new PriorityQueue<>((a,b)-> a.diff-b.diff);
        pq.add(new pair(0,0,0));
        distance[0][0] = 0;
        while(!pq.isEmpty()){
            int diff = pq.peek().diff, i = pq.peek().i, j = pq.peek().j;
            if(i == n-1 && j == m-1) return diff;
            pq.remove();
            for(int each[]: directions){
                int nrow = i + each[0];
                int ncol = j + each[1];
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m){
                    int newEffort = Math.max(Math.abs(heights[i][j]-heights[nrow][ncol]),diff);
                    if(newEffort < distance[nrow][ncol]){
                        distance[nrow][ncol] = newEffort;
                        pq.add(new pair(newEffort,nrow,ncol));
                    }
                }
            }
        }
        return distance[n-1][m-1];
    }
}