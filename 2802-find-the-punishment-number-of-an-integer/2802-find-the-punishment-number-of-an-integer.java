class Solution {
    public boolean check(int sq, int num){
        if(num < 0 || sq < num){
            return false;
        }
        if(num == sq){
            return true;
        }
        return (
            check(sq/10, num - (sq % 10)) || 
            check(sq/100, num - (sq % 100)) || 
            check(sq/1000, num - (sq % 1000))
        );
    }
    public int punishmentNumber(int n) {
        int punish = 0;
        for(int num = 1; num <= n;  num++){
            int sq = num * num;
            if(check(sq, num)){
                punish += sq;
            }
        }
        return punish;
    }
}