class Solution {
    class tuple{
        int price;
        int stop;
        int v;
        tuple(int price,int stop, int v){
            this.price = price;
            this.stop = stop;
            this.v = v;
        }
    }
    class pair{
        int v;
        int cost;
        pair(int v,int cost){
            this.v = v;
            this.cost = cost;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<pair>> adj= new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int flight[]: flights){
            int u = flight[0], v = flight[1], cost = flight[2];
            adj.get(u).add(new pair(v,cost));
        }
        //Initial Configuration for Dijikstra Algo 
        int dist[] = new int[n];
        for(int i=0;i<n;i++) dist[i] = (int)(1e9);
        Queue<tuple> pq = new LinkedList<>();
        pq.add(new tuple(0,0,src));
        dist[src] = 0;
        while(!pq.isEmpty()){
            int price = pq.peek().price, stop = pq.peek().stop, v = pq.peek().v;
            pq.remove();
            if(stop > k) continue;
            for(pair it: adj.get(v)){
                int adjNode = it.v;
                int cost = it.cost;
                if(stop <= k && price+cost < dist[adjNode]){
                    dist[adjNode] = price + cost;
                    pq.add(new tuple(price+cost, stop+1, adjNode));
                }
            }
        }
        if(dist[dst] == (int)(1e9)) return -1;
        return dist[dst];
    }
}