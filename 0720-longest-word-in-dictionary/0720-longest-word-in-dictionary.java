//Similar to Complete String or Longest String with All Prefixes
class Node {
    Node links[];
    boolean isEnd;
    Node(){
        links = new Node[26];
        isEnd = false;
    }
    void setEnd(){
        isEnd = true;
    }
    boolean contains(char ch){
        return links[ch - 'a'] != null;
    }
    void createNode(char ch){
        links[ch-'a'] = new Node();
    }
    Node getNode(char ch){
        return links[ch - 'a'];
    }
    boolean isEnd(){
        return isEnd;
    }
}
class Trie {
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
            node = node.getNode(ch);
        }
        node.setEnd();
    }
    boolean contains(String word){
        Node node = root;
        for(char ch: word.toCharArray()){
            node = node.getNode(ch);
            if(node.isEnd() == false){
                return false;
            }
        }
        return node.isEnd();
    }
}
class Solution {
    public String longestWord(String[] words) {
        Trie t = new Trie();
        for(String each: words){
            t.insert(each);
        }
        String completeString = "";
        for(String each: words){
            if(t.contains(each)){
                if(completeString.length() < each.length()){
                    completeString = each;
                }
                else if((completeString.length() == each.length()) && (completeString.compareTo(each)) > 0){
                    System.out.println(completeString.compareTo(each));
                    completeString = each;
                }
            }
        }
        return completeString;
    }
}