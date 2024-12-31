class Node{
    Node links[];
    Node(){
        links = new Node[26];
    }
    boolean contains(char ch){
        return (this.links[ch-'a'] != null);
    } 
    void createNode(char ch){
        this.links[ch-'a'] = new Node();
    }
    Node getNode(char ch){
        return this.links[ch-'a'];
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
            node = node.getNode(ch);
        }
    }
}
class Solution {
    public String longestCommonPrefix(String[] strs) {
        Trie t = new Trie();
        if (strs.length == 0) return "";
        String minLengthString = strs[0];
        //Inserting all the Words in the trie 
        for(String each: strs){
            if(each.length() < minLengthString.length()){
                minLengthString = each;
            }
            if (each.equals("")) return ""; 
            t.insert(each);
        }
        //Checking for the Longest Common Prefix Word
        int index =  getLongestCommonPrefix(t,minLengthString);
        return minLengthString.substring(0,index);
    }
    public int getLongestCommonPrefix(Trie t, String minWord){
        Node node = t.root;
        for(int i=0;i<minWord.length();i++){
            int childCount = 0;
            Node saveNode = null;
            for(int j=0;j<26;j++){
                if(node.links[j] != null){
                    childCount++;
                    saveNode = node.links[j];
                }
            }
            node = saveNode;
            if(childCount > 1){
                return i;
            }
        }
        return minWord.length();
    }
}