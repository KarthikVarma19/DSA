class Solution {
    public boolean canMakeSubsequence(String str, String str1) {
        int i = 0, j = 0;
        int n = str.length(), m = str1.length();
        while(i<n && j< m){
            if(
            (str.charAt(i) == str1.charAt(j)) || 
            ((str.charAt(i) == 'z') && 'a' == str1.charAt(j)) || 
            ((str.charAt(i) + 1) == str1.charAt(j))
            ){
                i++;
                j++;
            }
           else{
            i++;
           }
        }
        return j==m;
    }
}