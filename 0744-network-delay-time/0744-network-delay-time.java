class Solution {
    class adjNode{
        int v;
        int weight;
        adjNode(int v, int weight){
            this.v = v;
            this.weight = weight;
        }
    }
    class pair{
        int time;
        int node;
        pair(int time,int node){
            this.time = time;
            this.node = node;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<adjNode>> adj = new ArrayList<>();
        int timeTaken[] = new int[n+1];
        for(int i=0;i<=n;i++) {
            timeTaken[i] = (int)(1e9);
            adj.add(new ArrayList<>());
        }
        for(int each[]: times){
            int u = each[0], v = each[1], w = each[2];
            adj.get(u).add(new adjNode(v,w));
        }
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(0,k));
        timeTaken[k] = 0;
        while(!q.isEmpty()){
            int time = q.peek().time, node = q.peek().node;
            q.remove();
            if(time > timeTaken[node]) continue;
            for(adjNode a: adj.get(node)){
                int nextNode = a.v, timeNeeded = a.weight;
                if(time + timeNeeded < timeTaken[nextNode]){
                    timeTaken[nextNode] = time + timeNeeded;
                    q.add(new pair(timeTaken[nextNode], nextNode));
                }
            }
        }
        int minimum = 0;
        for(int i=1;i<=n;i++){
            if(timeTaken[i] == (int)(1e9)) return -1;
            minimum = Math.max(minimum, timeTaken[i]);
        }
        return minimum;
   }
}