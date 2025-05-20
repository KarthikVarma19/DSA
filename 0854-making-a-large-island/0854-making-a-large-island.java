class Solution {
    class Disjointset{
        int parent[];
        int rank[];
        int size[];
        Disjointset(int n){
            parent = new int[n];
            rank = new int[n];
            size = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }
        void union(int u, int v){
            int ulp_u = findUltimateParent(u);
            int ulp_v = findUltimateParent(v);
            if(ulp_u == ulp_v) return;
            if(rank[ulp_u] < rank[ulp_v]){
                parent[ulp_u] = ulp_v;
                size[ulp_v] += size[ulp_u];
            }else if(rank[ulp_v] < rank[ulp_u]){
                parent[ulp_v] = ulp_u;
                size[ulp_u] += size[ulp_v];
            }else {
                parent[ulp_v] = ulp_u;
                size[ulp_u] += size[ulp_v];
                rank[ulp_u]++;
            }
        }
        int findUltimateParent(int node){
            if(node == parent[node]){
                return node;
            }
            return parent[node] = findUltimateParent(parent[node]); // path compression
        }
        int getSize(int node){
            int ultParent = findUltimateParent(node);
            return size[ultParent];

        }
        
    }
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Disjointset djs = new Disjointset(n * m );

        int dr[] = {-1, 0, 1, 0};
        int dc[] = {0, 1, 0, -1};

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 0) continue;
                int node = (i * m) + j;
                for(int k = 0; k < 4; k++){
                    int ni = i + dr[k], nj = j + dc[k];
                    if(ni >= 0 && ni < n && nj >= 0 && nj < m && grid[ni][nj] == 1){
                        int adjNode = (ni * m) + nj;
                        djs.union(node, adjNode);
                    }
                }
            }
        }
        int maxarea = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 0){
                    int node = (i * m) + j;
                    Set<Integer> components = new HashSet<>();
                    int size = 1; 
                    // take the current into the consideration and check it's four direction if any 1's present then consider it's size and add into current total size
                    for(int k = 0; k < 4; k++){
                        int ni = i + dr[k], nj = j + dc[k];
                        if(ni >= 0 && ni < n && nj >= 0 && nj < m && grid[ni][nj] == 1){
                            int adjNode = (ni * m) + nj;
                            int ult_adjnode = djs.findUltimateParent(adjNode);
                            if(components.contains(ult_adjnode) == false){
                                components.add(ult_adjnode);
                                size += djs.getSize(adjNode);
                            }
                        }
                    }
                    maxarea = Math.max(maxarea, size);
                }
            }
        }
        for(int i = 0; i < n * m; i++){
            maxarea = Math.max(maxarea, djs.getSize(i));
        }
        return maxarea;
    }
}