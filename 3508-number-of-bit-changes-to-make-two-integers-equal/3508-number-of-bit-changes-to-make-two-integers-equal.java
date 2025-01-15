class Solution {
    public int minChanges(int n, int k) {
        int changes = 0;
        for(int i = 0; i < 32; i++){
            int nbit = (n>>i) & 1;
            int kbit = (k>>i) & 1;
            if(nbit != kbit){
                if(nbit != 1){
                    return -1;
                }
                changes++;
            }
        }
        return changes;
    }
}