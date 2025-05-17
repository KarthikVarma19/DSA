class Solution {
    class Disjointset{
        int parent[];
        int rank[];
        int size;
        Disjointset(int n){
            size = n;
            parent = new int[n+1];
            rank = new int[n+1];
            for(int i = 0; i <= size; i++){
                parent[i] = i;
            }
        }
        int findUltimateParent(int node){
            if(node == parent[node]){
                return node;
            }
            // Path Compression Using Backtracking
            return parent[node] = findUltimateParent(parent[node]);
        }
        // Returns 1 if both are in same component
        int unionByRank(int u, int v){
            int ulp_u = findUltimateParent(u);
            int ulp_v = findUltimateParent(v);
            // no need to connect again they belong to same union/component
            if(ulp_u == ulp_v) return 1; 
            if(rank[ulp_u] < rank[ulp_v]){
                parent[ulp_u] = ulp_v;
            } else if(rank[ulp_v] < rank[ulp_u]){
                parent[ulp_v] = ulp_u;
            }else{
                parent[ulp_v] = ulp_u;
                rank[ulp_u]++;
            }
            return 0;
        }
        int findComponents(){
            int comps = 0;
            for(int i = 0; i < size; i++){
                if(i == parent[i]){
                    comps++;
                }
            }
            return comps;
        }
    }
    public int makeConnected(int n, int[][] connections) {
        Disjointset djs = new Disjointset(n);
        int extraEdges = 0;
        for(int edge[]: connections){
            int u = edge[0], v = edge[1];
            extraEdges += djs.unionByRank(u, v);
        }
        int totalIndividualComponents = djs.findComponents();
        int ans = totalIndividualComponents - 1;
        if(extraEdges >= ans){
            return ans;
        }
        return -1;
    }
}