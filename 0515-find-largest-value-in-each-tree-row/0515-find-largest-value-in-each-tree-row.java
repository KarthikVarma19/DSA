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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> maxAtEachLevel = new ArrayList<>();
        Queue<TreeNode> levelElements = new LinkedList<>();
        if(root == null){
            return maxAtEachLevel;
        }
        levelElements.add(root);
        while(levelElements.size() != 0){
            int levelSize = levelElements.size();
            int maxElement = levelElements.peek().val;
            for(int i=0;i<levelSize;i++){
                TreeNode node = levelElements.remove();
                maxElement = Math.max(maxElement,node.val);
                if(node.left != null){
                    levelElements.add(node.left);
                }
                if(node.right != null){
                    levelElements.add(node.right);
                }
            }
            maxAtEachLevel.add(maxElement);
        }
        return maxAtEachLevel;
    }
}