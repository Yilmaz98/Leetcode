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
    
    StringBuilder sb = new StringBuilder();

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root != null)
            sb.append(root.val + ",");
        else    
            sb.append("&,");
        if(root !=null) {
            serialize(root.left);
            serialize(root.right);
        }
        
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        Queue<String> q = new LinkedList<>();
        
        for(int i=0;i<nodes.length;i++) {
            q.add(nodes[i]);
        }
        
        return helper(q);
    }
    
    public TreeNode helper(Queue<String> q) {
        if(q.peek().equals("&")) {
            q.poll();
            return null;
        }
            
        TreeNode root = new TreeNode(Integer.valueOf(q.poll()));
        root.left = helper(q);
        root.right = helper(q);
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));