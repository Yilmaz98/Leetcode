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
    
    int sum;
    public int diameterOfBinaryTree(TreeNode root) {
        sum = 0;
        dfs(root);
        return sum;
    }
    
    public int dfs(TreeNode root) {
        if(root == null) 
            return 0;
        
        int l = dfs(root.left);
        int r = dfs(root.right);
        
        sum = Math.max(sum, l+r);
        
        return Math.max(l,r) + 1;
    }
}