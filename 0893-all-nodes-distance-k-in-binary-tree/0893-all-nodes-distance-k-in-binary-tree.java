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
    public void saveParent(TreeNode root, Map<TreeNode,TreeNode> parent){
        if(root == null){
            return;
        }
        if(root.left != null){
            parent.put(root.left, root);
            saveParent(root.left, parent);
        }
        if(root.right != null){
            parent.put(root.right, root);
            saveParent(root.right, parent);
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> parent = new HashMap<>();
        saveParent(root, parent);
        Queue<TreeNode> q = new LinkedList<>();
        Boolean vis[] = new Boolean[501];
        Arrays.fill(vis, false);
        q.add(target);
        vis[target.val] = true;
        int curDis = 0;
        while(!q.isEmpty()){
            int curSize = q.size();
            if(curDis++ == k){
                break;
            }
            for(int i = 0; i < curSize; i++){
                TreeNode front = q.poll();
                if(parent.get(front) != null && vis[parent.get(front).val] == false){
                    q.add(parent.get(front));
                    vis[parent.get(front).val] = true;
                }
                if(front.left != null && vis[front.left.val] != true){
                    q.add(front.left);
                    vis[front.left.val] = true;
                }
                if(front.right != null && vis[front.right.val] != true){
                    q.add(front.right);
                    vis[front.right.val] = true;
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