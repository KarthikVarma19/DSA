/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return root;
        }
        TreeNode cur = root;
        if(p.val > q.val){
            TreeNode temp = p;
            p = q;
            q = temp;
        }
        while(cur != null){
            if(p.val <= cur.val && q.val >= cur.val){
                return cur;
            }
            else if(p.val <= cur.val && q.val <= cur.val){
                cur = cur.left;
            }
            else{
                cur = cur.right;
            }
        }
        return null;
    }
}