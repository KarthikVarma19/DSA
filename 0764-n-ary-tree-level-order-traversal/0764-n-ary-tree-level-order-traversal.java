/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int qSize = q.size();
            for(int j=0;j<qSize;j++){
                Node temp = q.remove();
                if(temp.children != null){
                    for(int i=0;i<temp.children.size();i++){
                        q.add(temp.children.get(i));
                    }
                }
                level.add(temp.val);
            }
            ans.add(level);
        }
        return ans;
    }
}