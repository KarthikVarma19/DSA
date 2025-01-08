class TrieNode{
    HashMap<Integer,TrieNode> links;
    int count;
    TrieNode(){
        links = new HashMap<>();
        count = 0;
    }
}
class Solution {
    private static int hash = 128;
    public long countPrefixSuffixPairs(String[] words) {
        long count = 0;
        TrieNode root = new TrieNode();
        for(String word: words){
            TrieNode node = root;
            for(int i = 0, n = word.length(); i < n; i++){
                int key = word.charAt(i) * hash + word.charAt(n-i-1);
                if(!node.links.containsKey(key)){
                    node.links.put(key, new TrieNode());
                }
                node = node.links.get(key);
                count += node.count;
            }
            node.count++;
        }
        return count;
    }
}