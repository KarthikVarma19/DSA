class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int dp[] = new int[n+1];
        dp[n] = 1;
        for(int ind = n-1; ind >= 0; ind--){
            if(s.charAt(ind) == '0'){
                dp[ind] = 0;
                continue;
            }
            int ways = 0;
            ways += dp[ind+1];
            if(ind < n-1 && ((s.charAt(ind)-'0') * 10 + (s.charAt(ind+1) - '0'))<27){
                ways += dp[ind+2];
            }
            dp[ind] = ways;
        }
        return dp[0];
    }
}