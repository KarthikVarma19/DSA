class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int prev1 = 1, prev2 = 0;
        for(int ind = n-1; ind >= 0; ind--){
            int curi = 0;
            if(s.charAt(ind) == '0'){
                curi = 0;
            }
            else{
                int ways = 0;
                ways += prev1;
                if(ind < n-1 && ((s.charAt(ind)-'0') * 10 + (s.charAt(ind+1) - '0'))<27){
                    ways += prev2;
                }
                curi = ways;
            }
            prev2 = prev1;
            prev1 = curi;
            
        }
        return prev1;
    }
}