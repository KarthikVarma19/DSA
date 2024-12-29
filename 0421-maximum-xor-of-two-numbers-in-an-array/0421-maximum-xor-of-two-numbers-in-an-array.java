class Node{
    Node links[];
    Node(){
        links = new Node[2];
    }
    boolean contains(int bit){
        return (links[bit] != null);
    }
    void createNode(int bit,Node newNode){
        links[bit] = newNode;
    }
    Node get(int bit){
        return links[bit];
    }
}
class Trie{
    Node root;
    Trie(){
        root = new Node();
    }
    void insert(int x){
        Node node = root;
        for(int i=31;i>=0;i--){
            int bit = (x>>i)&1;
            if(bit != 0) bit = 1;
            if(!node.contains(bit)){
                node.createNode(bit,new Node());
            }
            node = node.get(bit);
        }
    }
    int findMaxXor(int x){
        Node node = root;
        int xor = 0;
        for(int i=31;i>=0;i--){
            int bit = (x>>i)&1;
            int reqBit = 1 - bit;
            if(node.contains(reqBit)){
                node = node.get(reqBit);
                xor = (xor) | (1<<i);
            }else{
                node = node.get(bit);
            }
        }
        return xor;
    }
}
class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie t = new Trie();
        for(int each: nums){
            t.insert(each);
        }
        int xor = 0;
        for(int each: nums){
            xor = Math.max(xor,t.findMaxXor(each));
        }
        return xor;
    }
}