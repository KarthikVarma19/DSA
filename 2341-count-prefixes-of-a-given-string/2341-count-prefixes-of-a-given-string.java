class Solution {
    public boolean isPrefix(String prefix, String word){
        if(prefix.length()>word.length()) return false;
        for(int i=0;i<prefix.length();i++){
            if(prefix.charAt(i) != word.charAt(i)) return false;
        }
        return true;
    }
    public int countPrefixes(String[] words, String s) {
        int counter = 0;
        for(String pref: words){
            if(isPrefix(pref,s)){
                counter++;
            }
        }   
        return counter;
    }
}