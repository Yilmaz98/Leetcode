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
public class QNode{
    TreeNode node;
    int sum;
    QNode(TreeNode node, int sum) {
        this.node = node;
        this.sum = sum;
    }
    
}
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return false;
        }
        
        int sum = 0;
        Queue<QNode> q = new LinkedList<>();
        q.offer(new QNode(root,root.val));
        
        while(!q.isEmpty()) {
            int size = q.size();
            
            for(int i=0;i<size;i++) {
            QNode curr = q.poll();
            TreeNode n = curr.node;
            
            if(n.left == null && n.right == null && curr.sum == targetSum) {
                        return true;
                }
            
            if(n.left !=null) {
                q.offer(new QNode(n.left,n.left.val + curr.sum));
            }
            
            if(n.right !=null) {
                q.offer(new QNode(n.right,n.right.val + curr.sum));
            }
        
        }
                        
            }
        return false;
    }
}