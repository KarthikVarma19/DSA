class Solution {
    public int commonFactors(int a, int b) {
        int ans = 0;
        if(a < b){
            ans = getFactors(a, b);
        } else {
            ans = getFactors(b, a);
        }
        return ans;
    }
    public int getFactors(int a, int b){
        int count = 0;
        for(int i = 1; i <= a; i++){
            if(a%i == 0 && b%i == 0){
                count++;
            }
        }
        return count;
    }
}