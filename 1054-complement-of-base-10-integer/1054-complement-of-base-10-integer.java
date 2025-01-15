class Solution {
    public int bitwiseComplement(int n) {
        int res = n;
        for(int i = 31; i>=0; i--){
            if(((res>>i)&1) == 1){
                int mask = (1<<(i+1)) - 1;
                return mask ^ n;
            }
        }
        return 1;
    }
}