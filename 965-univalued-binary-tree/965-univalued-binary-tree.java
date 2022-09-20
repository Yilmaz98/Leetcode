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
    public void inorder(TreeNode root, Set<Integer>s) {
        if(root != null) {
            inorder(root.left,s);
            s.add(root.val);
            inorder(root.right,s);
        }
    }
    public boolean isUnivalTree(TreeNode root) {
        Set<Integer> s = new HashSet<>();
        inorder(root, s);
        
        return s.size() == 1;
    }
}