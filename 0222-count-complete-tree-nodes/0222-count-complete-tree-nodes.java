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
    public int leftHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1 + leftHeight(root.left);
    }
    public int rightHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1 + rightHeight(root.right);
    }
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int lh = leftHeight(root);
        int rh = rightHeight(root);
        if(lh == rh){
            return (1<<lh)-1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}