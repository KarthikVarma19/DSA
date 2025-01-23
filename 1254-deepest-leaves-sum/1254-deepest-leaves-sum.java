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
    class pair{
        int level;
        TreeNode t;
        pair(int level, TreeNode t){
            this.level = level;
            this.t = t;
        }
    }
    public int deepestLeavesSum(TreeNode root) {
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(0, root));
        
        while(!q.isEmpty()){
            int size = q.size();
            int levelSum = 0;
            for(int i = 0; i < size; i++){
                TreeNode temp = q.peek().t;
                levelSum += q.peek().t.val;
                int level = q.peek().level;
                q.remove();
                if(temp.left != null){
                    q.add(new pair(level+1, temp.left));
                }
                if(temp.right != null){
                    q.add(new pair(level+1, temp.right));
                }
            }
            if(q.isEmpty()) return levelSum;
        }
        return root.val;
    }
}