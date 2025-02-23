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
    int n;
    String s;
    int idx;
    public TreeNode recoverFromPreorder(String traversal) {
        n = traversal.length();
        s = traversal;
        idx = 0;
        return solve(0);
    }
    private TreeNode solve(int D){
        if(idx >= n) return null;

        int j = idx, d = 0;
        while(j < n && s.charAt(j) == '-'){
            j++;
            d++;
        }
        if(d != D) return null;
        idx = j;
        int val = 0;
        while(idx < n && Character.isDigit(s.charAt(idx))){
            val = (val * 10 ) + (s.charAt(idx++) - '0');
        }

        TreeNode root = new TreeNode(val);
        root.left = solve(D+1);
        root.right = solve(D+1);
        return root;
    }
}