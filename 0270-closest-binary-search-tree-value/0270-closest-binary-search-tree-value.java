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
    public int closestValue(TreeNode root, double target) {
        int[] closestValue = new int[1];
        Arrays.fill(closestValue, Integer.MAX_VALUE);
        double minDiff = Double.MAX_VALUE;
        inorder(root, target, minDiff, closestValue);
        return closestValue[0];
    }
    
    
    public void inorder(TreeNode root, double target, double minDiff, int[] closestValue) {
        if(root == null)
            return;
        if(Math.abs(root.val - target) <= minDiff) {
            if(Math.abs(root.val - target) == minDiff) 
                closestValue[0] = Math.min(root.val, closestValue[0]);
            else {
                minDiff = Math.abs(root.val - target);
                closestValue[0] = root.val;
            }
        }
        inorder(root.left, target, minDiff, closestValue);
        inorder(root.right, target, minDiff, closestValue);
    }
}