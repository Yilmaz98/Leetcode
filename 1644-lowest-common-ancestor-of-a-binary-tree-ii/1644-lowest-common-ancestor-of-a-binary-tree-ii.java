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
    TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ans = null;
        recurseTree(root, p, q);
        return ans;
    }
    
    
    public int recurseTree(TreeNode root, TreeNode p, TreeNode q) {        
        if(root == null)
            return 0;
        
        int left = recurseTree(root.left, p, q) > 0 ? 1 : 0;
        int right = recurseTree(root.right, p, q) > 0 ? 1 : 0;
        
        int mid = (root == p) || (root == q) ? 1 : 0;
        
        if(mid + left + right >= 2) {
            ans = root;
            return 1;
        }
        
        return (mid + left + right > 0 ? 1 : 0);
    }
}