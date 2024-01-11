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
    Integer maxPathSum;
    public int maxPathSum(TreeNode root) {
        maxPathSum = Integer.MIN_VALUE;
        height(root);
        
        return maxPathSum;
    }
    public int height(TreeNode root) {
        if(root == null)
            return 0;
        
        int left = Math.max(0, height(root.left));
        int right = Math.max(0, height(root.right));
        
        int sum = root.val + left + right;
        
        maxPathSum = Math.max(maxPathSum, sum);
        
        return root.val + Math.max(left, right);
    }
}