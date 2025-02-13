/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "";
        }
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode peek = q.poll();
            if(peek == null){
                sb.append("X ");
                continue;
            }
            sb.append(peek.val + " ");
            q.add(peek.left);
            q.add(peek.right);
        }
        System.out.println(sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == ""){
            return null;
        }
        String arr[] = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        for(int i = 1; i < arr.length; i++){
            TreeNode peek = q.poll();
            if(!arr[i].equals("X")){
                peek.left = new TreeNode(Integer.parseInt(arr[i]));
                q.add(peek.left);
            }
            if(!arr[++i].equals("X")){
                peek.right = new TreeNode(Integer.parseInt(arr[i]));
                q.add(peek.right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));