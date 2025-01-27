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
    int pathsum = 0;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        List<Integer> path = new ArrayList<>();
        preOrder(root, ans, path, targetSum);
        return ans;
    }
    public void preOrder(TreeNode root, List<List<Integer>> ans, List<Integer> path, int target){
        if(root == null){
            return;
        }
        path.add(root.val);
        pathsum += root.val;
        if(root.left == null && root.right == null){
            if(pathsum == target){
                ans.add(new ArrayList<>(path));
            }
            path.remove(path.size()-1);
            pathsum -= root.val;
             return;
        }
        preOrder(root.left, ans, path, target);
        preOrder(root.right, ans, path, target);
        path.remove(path.size()-1);
        pathsum -= root.val;
    }
}