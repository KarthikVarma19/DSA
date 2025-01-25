class Solution {
    //In, Memoization Solution It Beats 48.00% Let's Tabulize it 
    public int minCut(String s) {
        int n = s.length();
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        //-1 Because It Cut's at last index as of our solutin does
        return f(0, s.toCharArray(), dp) - 1;
    }
    //Helper Function Tells the minimum cuts needed to make palindrome partition
    public int f(int i, char s[], int dp[]){
        if(i == s.length) return 0;
        if(dp[i] != -1) return dp[i];
        int mini = Integer.MAX_VALUE;
        for(int ind = i; ind < s.length; ind++){
            if(isPalindrome(i, ind, s)){
                int cuts = 1 + f(ind+1, s, dp);
                mini = Math.min(mini, cuts);
            }
        }
        return dp[i] = mini;
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