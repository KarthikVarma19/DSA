class Solution {
    public int countPrimes(int n) {
        if(n == 0) return 0;
        boolean seive[] = new boolean[n+1];
        seive[1] = true;
        for(int i = 2;  i*i <= n; i++){
            if(seive[i] == false){
                for(int j = i + i; j < n; j = j + i){
                    seive[j] = true;
                }
            }
        }
        int count = 0;
        for(int i = 2; i < n; i++){
            if(seive[i] == false) count++;
        }
        return count;
    }
}