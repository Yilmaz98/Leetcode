/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        
        if(root == p || root == q)
            return root;
        
        return lca(root, p,q);
    }
    
    public TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
          if(root.val == p.val || root.val == q.val)
            return root;
        if(root == null)
            return null;
        
        TreeNode left = null, right = null;
        if(root.left != null) 
             left = lca(root.left, p, q);
        
        if(root.right != null)
             right = lca(root.right, p, q);
        
        if(left != null && right != null)
            return root;
        
        return left != null ? left : right;
    }
}