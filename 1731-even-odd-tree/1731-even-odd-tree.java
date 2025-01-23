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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            int valCond = (level%2==0)?0:(int)1e7;
            for(int i = 0; i < size; i++){
                TreeNode temp = q.remove();
                if(level % 2 == 0){
                    if((temp.val % 2 == 0 || valCond >= temp.val)) return false;
                }
                else{
                    if((temp.val % 2 == 1 || valCond <= temp.val)) return false;
                }
                valCond = temp.val;
                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
            }
            level++;

        }
        return true;
    }
}