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
    public boolean checkTree(TreeNode root) {
       if((root == null) || (root.left==null&&root.right==null)){
        return true;
       }
       int leftData = 0;
       int rightData = 0;
       if(root.left != null){
        leftData = root.left.val;
       }  
       if(root.right != null){
        rightData = root.right.val;
       }
       if((root.val == (leftData+rightData))){
        if(checkTree(root.left) && checkTree(root.right)){
            return true;
        }
       }
       return false;
    }
}