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
    public int sumNumbers(TreeNode root) {
        int sum[] = new int[1];
        sumNumbers(root,0,sum);
        return sum[0];
    }
    public void sumNumbers(TreeNode root, int val, int sum[]){
        if(root == null){
            return;
        }
        val += root.val;
        if(root.left == null && root.right == null){
            sum[0] += val;
        }
        sumNumbers(root.left, val * 10, sum);
        sumNumbers(root.right, val * 10, sum);
    }
}