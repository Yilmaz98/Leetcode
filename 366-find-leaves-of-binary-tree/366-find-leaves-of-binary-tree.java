/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        while(root != null) {
            List<Integer> leaves = new ArrayList<>();
            root = removeLeaves(root, leaves);
            result.add(leaves);
        }
        
        return result;
    }
    
    
    public TreeNode removeLeaves(TreeNode root, List<Integer> leaves) {
        if(root == null)
            return null;
        
        if(root.left == null && root.right == null) {
            leaves.add(root.val);   
            return null;
        }
        
        root.left = removeLeaves(root.left, leaves);
        root.right = removeLeaves(root.right, leaves);
        
        return root;
    }
}