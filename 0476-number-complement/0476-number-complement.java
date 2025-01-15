class Solution {
    public int findComplement(int num) {
        int res = num;
        for(int i=31;i>=0;i--){
            if(((res>>i)&1) == 1){
                int mask = (1<<i+1) - 1;
                return num ^ mask;    
            }
        }
        return 1;
    }
}