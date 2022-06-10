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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        if(p == null) {
            return false;
        }
        if(q == null) {
            return false;
        }
        
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.offer(p);
        q2.offer(q);
        
        while(!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode m = q1.poll();
            TreeNode n = q2.poll();
            
            if(m.val != n.val) {
                return false;
            }
            
            if(m.left != null && n.left !=null) {
                q1.offer(m.left);
                q2.offer(n.left);
            } 
            
            if((m.left != null && n.left ==null) || (m.right != null && n.right == null) || (m.left == null && n.left != null) || (m.right == null && n.right != null)) {
                return false;
            }
            
            if(m.right != null && n.right !=null) {
                q1.offer(m.right);
                q2.offer(n.right);
            }
        }
        
        return true;
        
    }
}