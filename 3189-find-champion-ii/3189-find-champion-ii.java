class Solution {
    public int findChampion(int n, int[][] edges) {
        int inDegree[] = new int[n];
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            inDegree[v]++;
        }
        int count = 0;
        int champion = -1;
        for(int i=0;i<n;i++){
            if(inDegree[i] == 0){
                count++;
                champion = i;
            }
        }
        if(count == 1) return champion;
        return -1;
    }
}