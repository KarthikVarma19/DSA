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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> leaves1 = new ArrayList<>();
        ArrayList<Integer> leaves2 = new ArrayList<>();
        inOrder(root1, leaves1);
        inOrder(root2, leaves2);
        return leaves1.equals(leaves2);

    }
    public void inOrder(TreeNode root, ArrayList<Integer> al){
        if(root == null){
            return;
        }
        inOrder(root.left, al);
        if(root.left == null && root.right == null){
            al.add(root.val);
        }
        inOrder(root.right,al);
    }
}