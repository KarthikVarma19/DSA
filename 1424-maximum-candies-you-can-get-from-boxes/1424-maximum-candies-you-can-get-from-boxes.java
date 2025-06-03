class Solution {
    public int maxCandies(
        int[] status, 
        int[] candies, 
        int[][] keys, 
        int[][] containedBoxes, 
        int[] initialBoxes
    ) {
        int count = 0;
        int n = status.length;
        boolean visited[] = new boolean[n];
        for(int v: initialBoxes){
            dfs(v, status, keys, containedBoxes, visited);
        }
        for(int i = 0; i < n; i++){
            if(visited[i] && status[i] == 1){
                count += candies[i];
            }
        }
        return count;
    }
    public void dfs(int v, int status[], int keys[][], int containedBoxes[][], boolean visited[]){
        visited[v] = true;
        for(int vKey: keys[v]){
            if(vKey == v) continue;
            status[vKey] = 1;
        }
        for(int vContained: containedBoxes[v]){
            if(!visited[vContained]){
                dfs(vContained, status, keys, containedBoxes, visited);
            }
        }
    }
}