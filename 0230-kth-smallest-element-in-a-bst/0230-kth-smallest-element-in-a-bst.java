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
    int K = 0, val = 0;
    public int kthSmallest(TreeNode root, int k) {
        K = k;
        inorder(root);
        return val;
    }
    
    public void inorder(TreeNode root) {
        if(root != null) {
            inorder(root.left);
            K--;
            if(K==0){
                val = root.val;
            }
            inorder(root.right);
        }
    }
}