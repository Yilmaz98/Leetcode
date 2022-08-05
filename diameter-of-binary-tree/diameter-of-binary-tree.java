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
        int sum=0;
    public int diameterOfBinaryTree(TreeNode root) {
        dbt(root);
        return sum;
    }
    
    public int dbt(TreeNode root){
        if(root == null) return 0;
        int l = dbt(root.left);
        int r = dbt(root.right);
        sum = Math.max(sum, l + r);
        return Math.max(l,r) +1;
    }
    }