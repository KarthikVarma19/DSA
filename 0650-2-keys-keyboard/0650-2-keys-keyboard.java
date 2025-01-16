class Solution {
    int n;
    public int minSteps(int n) {
        if(n == 1) return 0;
        this.n = n;
        return 1 + f(1, 1);
    }
    public int f(int ind, int sel){
        if(ind == n){
            return 0;
        }
        if(ind > n){
            return 1000;
        }
        //copy all + paste 
        int opt1 = 2 + f(ind*2, ind);
        //paste
        int opt2 = 1 + f(ind+sel, sel);
        
        return Math.min(opt1, opt2);
    }
}