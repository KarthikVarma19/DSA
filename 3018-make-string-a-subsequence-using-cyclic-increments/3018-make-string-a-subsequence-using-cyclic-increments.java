class Solution {
    public boolean canMakeSubsequence(String str, String str1) {
        int i = 0, j = 0;
        while(i<str.length() && j< str1.length()){
            if(
            (str.charAt(i) == str1.charAt(j)) || 
            ((str.charAt(i) + 1) == str1.charAt(j)) ||
            ((str.charAt(i) - 25) == str1.charAt(j)) 
            ){
                j++;
            }
            i++;
        }
        return j==str1.length();
    }
}