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
    public int sumNumbers(TreeNode root) {
        int[] sum = new int[1];
        inorder(root, 0, sum);
        return sum[0];
    }
    
    public void inorder(TreeNode root, int sum, int[] ans) {
        if(root != null) {
            sum = sum * 10 + root.val;
            inorder(root.left, sum, ans);
            inorder(root.right, sum, ans);
                        if(root.left == null && root.right == null) {
                ans[0] += sum;
            }
        }
    }
}