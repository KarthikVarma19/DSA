class Solution {
    public boolean judgeSquareSum(int c) {
        int low = 0;
        int high = (int)Math.sqrt(c);
        while(low <= high){
            long a = low * low;
            long b = high * high;
            if(a + b == (long)c){
                return true;
            }
            else if((a + b) < (long)c){
                low = low + 1;
            }
            else{
                high = high - 1;
            }
        }
        return false;
    }
}