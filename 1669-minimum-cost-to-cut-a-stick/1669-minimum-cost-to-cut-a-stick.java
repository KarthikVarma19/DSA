class Solution {
    public int minCost(int n, int[] cuts) {
        int c = cuts.length;
        int temp[] = new int[c+2];
        temp[0] = 0;
        for(int i = 0; i < c; i++){
            temp[i+1] = cuts[i];
        }
        temp[c+1] = n;
        Arrays.sort(temp);
        return f(1, c, temp);
    }
    public int f(int i, int j, int cuts[]){
        if(i>j) return 0;
        int mini = Integer.MAX_VALUE;
        for(int ind = i; ind <= j; ind++){
            int cost = cuts[j+1] - cuts[i-1] + f(i, ind-1, cuts) + f(ind+1, j, cuts);
            if(cost < mini){
                mini = cost;
            }
        }
        return mini;
    }
}