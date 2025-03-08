class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        //prefix sum
        int p[] = new int[n];
        if(blocks.charAt(0) == 'W') p[0] = 1;
        for(int i = 1; i < n; i++){
            p[i] = p[i-1];
            if(blocks.charAt(i) == 'W'){
                p[i] += 1;
            }
        }
        //sliding window
        int i = 1, j = k;
        int mini = p[j-1];
        while(j < n){
            int whites = p[j] - p[i-1];
            mini = Math.min(mini, whites);
            j++;
            i++;
        }
        return mini;
    }
}