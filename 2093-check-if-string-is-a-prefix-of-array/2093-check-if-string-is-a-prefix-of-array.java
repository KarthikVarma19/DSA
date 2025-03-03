class Solution {
    public boolean isPrefixString(String s, String[] words) {
        int p = 0;
        for(String each: words){
            for(int i=0;i<each.length();i++){
                if(p<s.length() && each.charAt(i) == s.charAt(p)){
                    p++;
                }
                else{
                    return false;
                }
            }
            if(p == s.length()) return true;
        }
        return p==s.length();
    }
}