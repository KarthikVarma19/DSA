class Solution {
    public int countPrimes(int n) {
        if(n == 0) return 0;
        int seive[] = new int[n+1];
        seive[1] = 1;
        int count = 0;
        for(int i = 2; i < n; i++){
            if(seive[i] == 0){
                count++;
                for(int j = i + i; j < n; j = j + i){
                    seive[j] = 1;
                }
            }
        }
        return count;
    }
}