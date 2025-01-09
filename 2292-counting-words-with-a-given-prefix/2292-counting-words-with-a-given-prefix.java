class TrieNode{
    TrieNode links[];
    boolean isEnd;

    TrieNode(){
        links = new TrieNode[26];
        isEnd = false;
    }

    void insert(String prefix, TrieNode root){
        TrieNode node = root;
        for(char ch: prefix.toCharArray()){
            if(node.links[ch-'a'] == null){
                node.links[ch-'a'] = new TrieNode();
            }
            node = node.links[ch-'a'];
        }
        node.isEnd = true;
    }

    boolean matches(String word, TrieNode root){
        TrieNode node = root;
        for(char ch: word.toCharArray()){
            if(node.links[ch-'a'] == null){
                return false;
            }
            node = node.links[ch-'a'];
            if(node.isEnd == true){
                return true;
            }
        }
        return node.isEnd;
    }
}
class Solution {
    public int prefixCount(String[] words, String pref) {
        TrieNode root = new TrieNode();
        root.insert(pref, root);
        int count = 0;
        for(String each: words){
            if(root.matches(each,root)){
                count += 1;
            }
        }
        return count;
    }
}