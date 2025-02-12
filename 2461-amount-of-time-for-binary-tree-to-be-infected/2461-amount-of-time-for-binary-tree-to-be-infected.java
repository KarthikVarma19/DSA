
class Solution {
      public void makeParent(TreeNode root, Map<TreeNode,TreeNode> parent){
        if(root == null){
            return;
        }
        if(root.left != null){
            parent.put(root.left, root);
        }
        if(root.right != null){
            parent.put(root.right, root);
        }
        makeParent(root.left, parent);
        makeParent(root.right, parent);
    }
    public TreeNode getRef(TreeNode root, int t){
        if(root == null) return null;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode ref = null;
        while(!q.isEmpty()){
            TreeNode peek = q.poll();
            if(peek.val == t){
                ref = peek;
                break;
            }
            if(peek.left != null){
                q.add(peek.left);
            }
            if(peek.right != null){
                q.add(peek.right);
            }
        }
        return ref;
        
    }
    public int amountOfTime(TreeNode root, int target) {
        Map<TreeNode,TreeNode> parent = new HashMap<>();
        makeParent(root, parent);
        TreeNode targetRef = getRef(root, target);
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