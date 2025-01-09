class TrieNode{
    TrieNode[] links;
    boolean isEnd;
    TrieNode(){
        links = new TrieNode[128];
        isEnd = false;
    }
    void insert(String word, TrieNode root){
        TrieNode node = root;
        for(char ch: word.toCharArray()){
            if(node.links[ch-'A'] == null){
                node.links[ch-'A'] = new TrieNode();
            }
            node = node.links[ch-'A'];
        }
        node.isEnd = true;
    }

    boolean match(TrieNode root, String word){
        TrieNode node = root;
        for(char ch: word.toCharArray()){
            if(node.links[ch-'A'] != null){
                node = node.links[ch-'A'];
            }
            else if(Character.isUpperCase(ch) == true){
                return false;
            }
        }
        return node.isEnd;
    }
}

class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList<>();
        TrieNode root = new TrieNode();
        root.insert(pattern,root);
        for(String each: queries){
            ans.add(root.match(root, each));    
        }
        return ans;
    }
}