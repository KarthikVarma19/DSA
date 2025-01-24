class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<Integer>());
        }
        int indegree[] = new int[V];
        for(int i=0;i<V;i++){
            int v = i;
            indegree[v] = graph[i].length; 
            for(int j=0;j<graph[i].length;j++){
                int u = graph[i][j];
                adj.get(u).add(v);
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int front = q.remove();
            for(Integer it: adj.get(front)){
                if(--indegree[it] == 0){
                    q.add(it);
                }
                
            }
        } 
        List<Integer> safe = new ArrayList<Integer>();
        for(int i=0;i<V;i++){
            if(indegree[i] == 0){
                safe.add(i);
            }
        }
        return safe;
    }
}