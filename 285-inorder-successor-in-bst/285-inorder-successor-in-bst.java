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
    List<TreeNode> result = new ArrayList<>();
    
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        inorder(root);
        
        for(TreeNode i: result) {
            if(i.val>p.val) {
                return i;
            }
        }
        return null;
    }
    
    public void inorder(TreeNode root) {
        if(root !=null) {
            inorder(root.left);
            result.add(root);
            inorder(root.right);        
        }
    }
}