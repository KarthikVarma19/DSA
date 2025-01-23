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
    public List<TreeNode> delNodes(TreeNode root, int[] d) {
        List<TreeNode> ans = new ArrayList<>();
        HashSet<Integer> hs = new HashSet<>();
        for(int it: d) hs.add(it);
        root = f(root, d, ans, hs);
        if(root != null){
            ans.add(root);
        }
        return ans;
    }
    public TreeNode f(TreeNode root, int d[], List<TreeNode> ans, HashSet<Integer> hs){
        if(root == null) return null;
        root.left = f(root.left, d, ans, hs);
        root.right = f(root.right, d, ans, hs);
        if(hs.contains(root.val)){
            if(root.left != null){
                ans.add(root.left);
            }
            if(root.right != null){
                ans.add(root.right);
            }
            return null;
        }
        return root;
    }
}