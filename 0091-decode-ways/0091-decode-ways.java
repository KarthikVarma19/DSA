class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        return f(0, s, dp);
    }
    public int f(int ind, String s, int dp[]){
        int n = s.length();
        if(ind == n) return 1;
        if(s.charAt(ind) == '0') return 0;
        if(dp[ind] != -1) return dp[ind];
        int ways = 0;
        ways += f(ind+1, s, dp);
        if(ind < n-1 && ((s.charAt(ind)-'0') * 10 + (s.charAt(ind+1) - '0'))<27){
            ways += f(ind+2, s, dp);
        }
        return dp[ind] = ways;
    }
}