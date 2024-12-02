class Solution {
    public boolean isPrefix(String word, String pref){
        if(pref.length() > word.length()) return false;
        for(int i=0;i<pref.length();i++){
            if(pref.charAt(i) != word.charAt(i)) return false;
        }
        return true;
    }
    public int prefixCount(String[] words, String pref) {
        int count = 0;
        for(String each: words){
            if(isPrefix(each,pref)){
                count++;
            }
        }
        return count;
    }
}