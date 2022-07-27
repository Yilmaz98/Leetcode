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
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) {
            return -1;
        }
        inorder(root);
        
        for(int i=1;i<k;i++) {
            pq.poll();
        }
        
        return pq.peek();
    }
    
    public void inorder(TreeNode root) {
        if(root == null)
            return;
        inorder(root.left);
        pq.offer(root.val);
        inorder(root.right);
    }
}