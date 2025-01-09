class TrieNode{
    HashMap<Character,TrieNode> links;
    boolean isEnd;
    TrieNode(){
        links = new HashMap<>();
        isEnd = false;
    }
    void insert(String word, TrieNode root){
        TrieNode node = root;
        for(char ch: word.toCharArray()){
            if(node.links.get(ch) == null){
                node.links.put(ch, new TrieNode());
            }
            node = node.links.get(ch);
        }
        node.isEnd = true;
    }

    boolean match(TrieNode root, String word){
        TrieNode node = root;
        for(char ch: word.toCharArray()){
            if(node.links.get(ch) != null){
                node = node.links.get(ch);
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