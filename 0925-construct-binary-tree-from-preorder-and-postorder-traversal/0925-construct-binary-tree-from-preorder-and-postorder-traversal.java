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
    int[] preorder;
    int[] postorder;
    int n;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        this.preorder = preorder;
        this.postorder = postorder;
        this.n = preorder.length;
        //sol(preStart, preEnd, postStart)
        return sol(0, n-1, 0);
    }
    private TreeNode sol(int preS, int preE, int postS){
        if(preS > preE) return null;
        if(preS == preE) return new TreeNode(preorder[preS]);
        
        int ptr = postS;
        int nl = 1;
        while(postorder[ptr] != preorder[preS+1]){
            nl++;
            ptr++;
        }
        TreeNode root = new TreeNode(preorder[preS]);
        root.left = sol(preS+1, preS+nl, postS);
        root.right = sol(preS+nl+1, preE, postS+nl);
        return root;
    }
}