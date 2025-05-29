class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if(n < 0){
            N = -N;
            x = 1/x;
        }
        return binExpo(x, N);
    }
    public double binExpo(double x, long n){
        if(n == 0){
            return 1;
        }
        double result = binExpo(x, n/2);
        result *= result;
        if(n%2 == 1){
            result *= x;
        }
        return result;
    }
}