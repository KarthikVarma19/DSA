class Solution {
    public boolean isPalindrome(String s){
        int i = 0, j = s.length() - 1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public int minCut(String s) {
        int dp[] = new int[s.length()+1];
        for(int ind = s.length()-1; ind >= 0; ind--){
            StringBuilder sb = new StringBuilder("");
            int mini = Integer.MAX_VALUE;
            for(int j = ind; j < s.length(); j++){
                sb.append(s.charAt(j));
                if(isPalindrome(sb.toString())){
                    int cost = 1 + dp[j+1];
                    mini = Math.min(cost, mini);
                }
            }
            dp[ind] = mini;
        }
        return dp[0]-1;
    }
}