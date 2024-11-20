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
    public int goodNodes(TreeNode root) {
        int pathMax = root.val;
        return getGoodNodes(root,pathMax);
    }
    public int getGoodNodes(TreeNode root,int pathMax){
        if(root == null){
            return 0;
        }
        pathMax = Math.max(pathMax,root.val);
        if(pathMax == root.val){
            return 1 + getGoodNodes(root.left,pathMax)+ getGoodNodes(root.right,pathMax);
        }
        return getGoodNodes(root.left,pathMax)+ getGoodNodes(root.right,pathMax);
        
    }
}