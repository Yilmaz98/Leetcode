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
    int nodes = 0;
    public int averageOfSubtree(TreeNode root) {
        inorder(root);
        return nodes;
    }
    
    public int[] inorder(TreeNode root) {
        if(root == null)
            return new int[]{0, 0};
        
        int[] left = inorder(root.left);
        int[] right = inorder(root.right);
        
        if(root.left == null && root.right == null) {
            nodes++;
            return new int[]{root.val, 1};
        }
            
        
        int sum = left[0] + right[0] + root.val;
        int count = left[1] + right[1] + 1;
        
        int average = sum / count;
        
        if(average == root.val) {
            nodes++;
        }
        
        return new int[]{sum, count};
    }
}