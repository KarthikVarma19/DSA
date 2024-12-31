class WordDictionary {
    Trie t;
    public WordDictionary() {
        t = new Trie();
    }
    
    public void addWord(String word) {
        t.insertWord(word);
    }
    
    public boolean search(String word) {
        return t.search(word,t.root);
    }
}
class Node{
    Node links[];
    boolean isEndOfWord;
    Node(){
        links = new Node[26];
        isEndOfWord = false;
    }
    boolean containsKey(char ch){
        return (links[ch-'a'] != null);
    }
    void create(char ch, Node newNode){
        links[ch-'a'] = newNode;
    }
    Node get(char ch){
        return links[ch-'a'];
    }
    void setEnd(){
        this.isEndOfWord = true;
    }
    
}
class Trie{
    Node root;
    Trie(){
        root = new Node();
    }
    void insertWord(String word){
        Node pCrawls = root;
        for(char ch: word.toCharArray()){
            if(!pCrawls.containsKey(ch)){
                pCrawls.create(ch,new Node());
            }
            pCrawls = pCrawls.get(ch);
        }
        pCrawls.setEnd();
    }
    boolean search(String word, Node root){
        Node pCrawls = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(ch == '.'){
                for(int j=0;j<26;j++){
                    if(pCrawls.links[j] != null){
                        if(search(word.substring(i+1,word.length()), pCrawls.links[j])){
                            return true;
                        }
                    }
                }
                return false;
            }
            else{
                if(!pCrawls.containsKey(ch)){
                    return false;
                }
                pCrawls = pCrawls.get(ch);
            }
        }
        return pCrawls.isEndOfWord;
    }
}
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */