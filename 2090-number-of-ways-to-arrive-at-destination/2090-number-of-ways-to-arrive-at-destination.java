class Solution {
    class adjNode{
        int v;
        int w;
        adjNode(int v, int w){
            this.v = v;
            this.w = w;
        }
    }
    class pair{
        long time;
        long node;
        pair(long time,long node){
            this.time = time;
            this.node = node;
        }
    }
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<adjNode>> adj = new ArrayList<>();
        long shortedTime[] = new long[n];
        long ways[] = new long[n];
        long max = (int)(1e9+7);
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
            shortedTime[i] = Long.MAX_VALUE;
            ways[i] = 0;
        }
        for(int[] edge: roads){
            adj.get(edge[0]).add(new adjNode(edge[1],edge[2]));
            adj.get(edge[1]).add(new adjNode(edge[0],edge[2]));
        }
        PriorityQueue<pair> q = new PriorityQueue<>((a,b)-> Long.compare(a.time,b.time));
        q.add(new pair(0,0));
        shortedTime[0] = 0;
        ways[0] = 1;
        while(!q.isEmpty()){
            long time = q.peek().time, node = q.peek().node;
            q.remove();
            for(adjNode a: adj.get((int)node)){
                long v = a.v, w = a.w;
                if(time + w < shortedTime[(int)v]){
                    shortedTime[(int)v] = time + w;
                    q.add(new pair(time + w, v));
                    ways[(int)v] = ways[(int)node];
                }
                else if(time + w == shortedTime[(int)v]){
                    ways[(int)v] = (ways[(int)node]+ways[(int)v])%max;
                }
            }
        }
        return (int)(ways[n-1]%max);
    }
}