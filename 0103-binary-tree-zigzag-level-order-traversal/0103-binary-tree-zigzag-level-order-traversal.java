
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null){
            return ans;
        }
        q.add(root);
        boolean flag = true;
        while(!q.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode peeek = q.poll();
                if(flag == false){
                    level.add(0, peeek.val);
                }else{
                    level.add(peeek.val);
                }
                if(peeek.left != null){
                    q.add(peeek.left);
                }
                if(peeek.right != null){
                    q.add(peeek.right);
                }
            }
            flag = !flag;
            ans.add(level);
        }
        return ans;
    }
}