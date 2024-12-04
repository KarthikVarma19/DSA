class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int dist[][] = new int[n][n];
        //Initial Configuration for Floyd Warshall Algorithm
        for(int[] edge: edges){
            int u = edge[0], v = edge[1], w = edge[2];
            dist[u][v] = w;
            dist[v][u] = w;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j && dist[i][j]==0){
                    dist[i][j] = (int)(1e9);
                }
            }
        }
        //Floyd's Warshall Algorithm 
        for(int via=0;via<n;via++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    dist[i][j] = Math.min(dist[i][j], dist[i][via] + dist[via][j]);
                }
            }
        }
        int minReachable =  n;
        int minCity = 0;
        for(int i=0;i<n;i++){
            int reachable = 0;
            for(int j=0;j<n;j++){
                if(dist[i][j] <= distanceThreshold){
                    reachable++;
                }
            } 
            if(reachable <= minReachable){
                minReachable = reachable;
                minCity = i;
            }
        }
        return minCity;
    }
}