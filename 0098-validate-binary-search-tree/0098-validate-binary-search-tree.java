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

public class QNode {
    TreeNode node;
    long left;
    long right;
    QNode(TreeNode node, long left, long right) {
        this.node = node;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public boolean isValidBST(TreeNode root) {
        Queue<QNode> q = new LinkedList<>();
        q.offer(new QNode(root,Long.MIN_VALUE, Long.MAX_VALUE));
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                QNode curr = q.poll();
                TreeNode n = curr.node;
                
                if(n.val >= curr.right || n.val <=curr.left) return false;
                
                if(n.left != null) {
                    q.offer(new QNode(n.left,curr.left,n.val));
                }
                
                if(n.right != null) {
                    q.offer(new QNode(n.right,n.val,curr.right));
                }
            } 
        }
        
        return true;
    }
}