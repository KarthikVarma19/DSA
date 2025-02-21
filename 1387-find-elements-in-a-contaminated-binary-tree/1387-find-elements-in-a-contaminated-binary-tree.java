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
    TreeNode ROOT;
    public FindElements(TreeNode root) {
        ROOT = root;
    }

    public boolean find(int target) {

        TreeNode node = ROOT;

        int path = target + 1;

        int depth = Integer.toBinaryString(path).length();

        int mask = 1 << (depth - 2);

        while(mask > 0 && node != null){
            if((path&mask) == 0){
                node = node.left;
            } else{
                node = node.right;
            }
            mask = mask >> 1;
        }
        return node!=null;

    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */