
class Solution {
      public TreeNode makeParent(TreeNode root, Map<TreeNode,TreeNode> parent, int target){
        if(root == null) return null;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode ref = null;
        while(!q.isEmpty()){
            TreeNode peek = q.poll();
            if(peek.val == target){
                ref = peek;
            }
            if(peek.left != null){
                parent.put(peek.left, peek);
                q.add(peek.left);
            }
            if(peek.right != null){
                parent.put(peek.right, peek);
                q.add(peek.right);
            }
        }
        return ref;
    }
    public int amountOfTime(TreeNode root, int target) {
        Map<TreeNode,TreeNode> parent = new HashMap<>();
        TreeNode targetRef = makeParent(root, parent, target);
        Queue<TreeNode> q = new LinkedList<>();
        Set<Integer> vis = new HashSet<>();
        q.add(targetRef);
        vis.add(target);
        int time = 0;
        while(!q.isEmpty()){
            int curSize = q.size();
            time++;
            for(int i = 0; i < curSize; i++){
                TreeNode peek = q.poll();
                if(parent.get(peek) != null && vis.contains(parent.get(peek).val) == false){
                    q.add(parent.get(peek));
                    vis.add(parent.get(peek).val);
                }
                if(peek.left != null && vis.contains(peek.left.val) == false){
                    q.add(peek.left);
                    vis.add(peek.left.val);
                }
                if(peek.right != null && vis.contains(peek.right.val) == false){
                    q.add(peek.right);
                    vis.add(peek.right.val);
                }
            }
        }
        return time-1;
    }
}