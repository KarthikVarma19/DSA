class Solution {
    public int isPrefixOfWord(String s, String w) {
        int c = 0, curWord = 1;
        for(int i=0;i<s.length();i++){
            if(c != -1 && s.charAt(i) == w.charAt(c)) c++;
            else if(s.charAt(i) == ' '){
                c = 0;
                curWord++;
            }
            else c = -1;
            if(c == w.length()) return curWord++;
        }
        return -1;
    }
}