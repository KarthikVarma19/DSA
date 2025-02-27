class Solution {
    private int timer = 1;
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
        int min[] = new int[n];
        List<List<Integer>> bridges = new ArrayList<>();
        
        //(node, parent, vis, tim, min, adj, bridges)
        dfs(0, -1, vis, tim, min, adj, bridges);

        return bridges;
    }
    public void dfs(int node, int parent, int vis[], int tim[], int min[], List<List<Integer>> adj, List<List<Integer>> bridges){
        vis[node] = 1;
        tim[node] = timer;
        min[node] = timer;
        timer++;
        for(Integer it: adj.get(node)){
            if(it == parent){
                continue;
            }
            //not visited
            if(vis[it] == 0){
                dfs(it, node, vis, tim, min, adj, bridges);
                //be greedy by taking it neighbout min time
                min[node] = Math.min(min[node], min[it]);
                //check if it can be a bridge
                //if current node's insertion time is less than the it's adjacent minimum insertion time than we can say that it is dependent on this only
                if(tim[node] < min[it]){
                    bridges.add(Arrays.asList(it, node));
                }
            }else{
                min[node] = Math.min(min[node], min[it]);
            }
        }
    }
}