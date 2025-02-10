class Solution {
    class Pair{
        TreeNode node;
        int level;
        Pair(TreeNode node, int level){
            this.node = node;
            this.level = level;
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        //Level Number -> Last Node in that Level
        Map<Integer,Integer> map = new TreeMap<>();        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        while(!q.isEmpty()){
            Pair p = q.remove();
            int curLevel = p.level;
            TreeNode curNode = p.node;
            map.put(curLevel, curNode.val);
            if(curNode.left != null){
                q.add(new Pair(curNode.left, curLevel+1));
            }
            if(curNode.right != null){
                q.add(new Pair(curNode.right, curLevel+1));
            }
        }
        List<Integer> rightView = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            rightView.add(entry.getValue());
        }
        return rightView;
    }
}