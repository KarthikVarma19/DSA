class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String words[] = sentence.split(" ");
        for(int i=0;i<words.length;i++){
            String word = words[i];
            if(word.length() >= searchWord.length() && isPrefix(word,searchWord)){
                return i+1;
            }
        }
        return -1;
    }
    public boolean isPrefix(String word, String searchWord){
        for(int i=0;i<searchWord.length();i++){
            if(searchWord.charAt(i) != word.charAt(i)){
                return false;
            }
        }
        return true;
    }
}