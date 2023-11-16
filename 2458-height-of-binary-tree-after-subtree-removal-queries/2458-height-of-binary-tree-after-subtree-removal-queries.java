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
    int[] l = new int[100001];
    int[] r = new int[100001];
    int[] h = new int[100001];
    
    public int[] treeQueries(TreeNode root, int[] queries) {
        height(root);
        solve(root.left, r[root.val], 1);
        solve(root.right, l[root.val], 1);
        
        int result[] = new int[queries.length];
        
        for(int i=0;i<queries.length;i++) {
            result[i] = h[queries[i]];    
        }
        
        return result;
    }
    
    public void solve(TreeNode root, int maxa, int depth) {
        if(root == null)
            return;
        
        h[root.val] = maxa;
        
        solve(root.left, Math.max(maxa, depth + r[root.val]), depth+1);
        solve(root.right, Math.max(maxa, depth + l[root.val]), depth+1);
    }
    
    public int height(TreeNode root) {
        if(root == null)
            return 0;
        
        int lh = height(root.left);
        int rh = height(root.right);
        
        l[root.val] = lh;
        r[root.val] = rh;
        
        return 1 + Math.max(lh, rh);
    }
}