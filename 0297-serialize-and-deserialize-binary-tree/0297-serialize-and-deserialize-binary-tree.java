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
    private int index = 0;
    public String serialize(TreeNode root) {
        StringBuilder data = new StringBuilder();
        serialize(root, data);
        return data.toString();
    }

    private void serialize(TreeNode node, StringBuilder data){
        if(node == null){
            data.append('#').append(' ');
        }else{
            data.append(node.val).append(' ');
            serialize(node.left, data);
            serialize(node.right, data);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(index < data.length()){
            String value = getValue(data);
            if("#".equals(value)){
                return null;
            }

            TreeNode node = new TreeNode(Integer.parseInt(value));
            node.left = deserialize(data);
            node.right = deserialize(data);
            return node;
        }

        throw new RuntimeException("Invalid Data");        
    }

    private String getValue(String data){
        int endPosition = data.indexOf(' ', index);
        String value = data.substring(index, endPosition);
        index = endPosition + 1;
        return value;
    }
}