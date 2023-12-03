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
    int count = 0;
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return count;
    }
    
    public int[] dfs(TreeNode root) {
        if(root == null)
            return new int[]{0,-1};
        
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        
        if(left[1] == -1 && right[1] == -1) {
            count++;
            return new int[]{root.val,1};
        }
        
        int sum = 0;
        int nodes = 0;
        
        if(left[1] == -1) {
            sum = (root.val + right[0]);
            nodes = (1 + right[1]);
        }
        else if(right[1] == -1) {
            sum = (root.val + left[0]);
            nodes = (1 + left[1]);
        }
        else {
            sum = (root.val + left[0] + right[0]);
            nodes = (1 + left[1] + right[1]);
        }
        
        if(sum/nodes == root.val) {
            count++;
        }
        
        return new int[]{sum, nodes};
    }
}