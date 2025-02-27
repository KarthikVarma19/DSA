class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < connections.size(); i++){
            int u = connections.get(i).get(0), v = connections.get(i).get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int vis[] = new int[n];
        int tim[] = new int[n];
        int timer[] = new int[1];
        List<List<Integer>> bridges = new ArrayList<>();
        
        //(node, parent, vis, tim, min, adj, bridges)
        dfs(0, -1, vis, tim, timer, adj, bridges);

        return bridges;
    }
    public void dfs(int node, int parent, int vis[], int min[], int timer[], List<List<Integer>> adj, List<List<Integer>> bridges){
        vis[node] = 1;
        min[node] = timer[0]++;
        int currentTime = min[node];
        for(Integer it: adj.get(node)){
            if(it == parent){
                continue;
            }
            //not visited
            if(vis[it] == 0){
                dfs(it, node, vis, min, timer, adj, bridges);
            }
            min[node] = Math.min(min[node], min[it]);
            if(currentTime < min[it]){
                bridges.add(Arrays.asList(node, it));
            }
        }
    }
}