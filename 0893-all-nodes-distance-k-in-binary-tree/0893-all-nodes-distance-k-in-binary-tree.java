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
    public void saveParent(TreeNode root, Map<TreeNode,TreeNode> parent, TreeNode target){
        if(root == null || root == target){
            return;
        }
        if(root.left != null){
            parent.put(root.left, root);
            saveParent(root.left, parent, target);
        }
        if(root.right != null){
            parent.put(root.right, root);
            saveParent(root.right, parent, target);
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> parent = new HashMap<>();
        saveParent(root, parent, target);
        Queue<TreeNode> q = new LinkedList<>();
        Set<Integer> vis = new HashSet<>();
        q.add(target);
        vis.add(target.val);
        int curDis = 0;
        while(!q.isEmpty()){
            int curSize = q.size();
            if(curDis++ == k){
                break;
            }
            for(int i = 0; i < curSize; i++){
                TreeNode front = q.poll();
                if(parent.get(front) != null && vis.contains(parent.get(front).val) != true){
                    q.add(parent.get(front));
                    vis.add(parent.get(front).val);
                }
                if(front.left != null && vis.contains(front.left.val) != true){
                    q.add(front.left);
                    vis.add(front.left.val);
                }
                if(front.right != null && vis.contains(front.right.val) != true){
                    q.add(front.right);
                    vis.add(front.right.val);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            ans.add(q.remove().val);
        }
        return ans;
    }
}