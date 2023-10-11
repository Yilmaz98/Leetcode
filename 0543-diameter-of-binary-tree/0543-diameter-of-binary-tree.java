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
    private int diameter;
    public int height(TreeNode root) {
        if(root == null)
            return 0;
        
        int l = height(root.left);
        int r = height(root.right);
        
        diameter = Math.max(diameter, l + r);
        
        return Math.max(l,r) + 1;
    }
    
    public int diameterOfBinaryTree(TreeNode root) { 
        diameter = 0;
        height(root);
        return diameter;
    }
}