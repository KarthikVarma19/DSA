class Node{
    int count;
    Node links[];
    Node(){
        count = 0;
        links = new Node[26];
    }
    boolean contains(char ch){
        return links[ch-'a'] != null;
    }
    void createNode(char ch){
        links[ch-'a'] = new Node();
    }
    void increment(){
        this.count++;
    }
    Node get(char ch){
        return links[ch-'a'];
    }
    int getCount(){
        return count;
    }
}
class Trie{
    Node root;
    Trie(){
        root = new Node();
    }
    void insert(String word){
        Node node = root;
        for(char ch: word.toCharArray()){
            if(!node.contains(ch)){
                node.createNode(ch);
            }
            node = node.get(ch);
            node.increment();
        }
    }
    boolean isSubstring(String word){
        Node node = root;
        for(char ch: word.toCharArray()){
            node = node.get(ch);
        }
        return node.getCount() > 1;
    }
}
class Solution {
    public List<String> stringMatching(String[] words) {
        Trie root = new Trie();
        for(String each: words){
            for(int i=0;i<each.length();i++){
                root.insert(each.substring(i));
            }
        }
        List<String> ans = new ArrayList<>();
        for(String each: words){
            if(root.isSubstring(each)){
                ans.add(each);
            }
        }
        return ans;
    }
}