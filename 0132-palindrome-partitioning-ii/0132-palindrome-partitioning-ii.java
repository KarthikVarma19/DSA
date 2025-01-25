class Solution {
    //In, Tabulation Solution It Beats
    //It is a Bottom Up Approach 
    //Since, in top down approach f(i) goes from 0 to n
    //So, Bottom Up Approach f(i) goes from n to 0;
    public int minCut(String s) {
        int n = s.length();
        int dp[] = new int[n+1];
        char str[] = s.toCharArray();
        for(int i = n-1; i >= 0; i--){
            int mini = Integer.MAX_VALUE;
            for(int ind = i; ind < str.length; ind++){
                if(isPalindrome(i, ind, str)){
                    int cuts = 1 + dp[ind+1];
                    mini = Math.min(mini, cuts);
                }
            }
            dp[i] = mini;
        }
        return dp[0] - 1;
    }
    //Function Tells if a String is palindrome or not in range(i, j)
    public boolean isPalindrome(int i, int j, char s[]){
        while(i<j){
            if(s[i] != s[j]) return false;
            i++;
            j--;
        }
        return true;
    }
}