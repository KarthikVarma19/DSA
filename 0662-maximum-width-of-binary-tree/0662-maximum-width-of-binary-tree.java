/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class Pair{
        TreeNode node;
        int index;
        Pair(TreeNode node, int index){
            this.node = node;
            this.index = index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        int maxWidth = 1;
        while(!q.isEmpty()){
            int levelSize = q.size();
            int first = -1, last = -1;
            while(levelSize-- > 0){
                Pair p = q.remove();
                int index = p.index;
                TreeNode node = p.node;
                if(node.left != null){
                    q.add(new Pair(node.left, (2 * index + 1)));
                }
                if(node.right != null){
                    q.add(new Pair(node.right, (2 * index + 2)));
                }
                if(first == -1){
                    first = index;
                }else{
                    last = index;
                }
            }
            //if we not found second non-null node
            if(last == -1){
                continue;
            }
            maxWidth = Math.max(maxWidth, last - first + 1);
        }
        return maxWidth;
    }
}