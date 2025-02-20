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
class FindElements {
    
    HashSet<Integer> hashSet = new HashSet<>();
    
    public FindElements(TreeNode root) {
        recoverBT(root, 0);
    }
    
    private void recoverBT(TreeNode root, int value){
        root.val = value;
        hashSet.add(value);
        if(root.left != null){
            recoverBT(root.left, 2 * value + 1);
        }
        if(root.right != null){
            recoverBT(root.right, 2 * value + 2);
        }
    }

    public boolean find(int target) {
        if(hashSet.contains(target)){
            return true;
        }
        return false;
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */