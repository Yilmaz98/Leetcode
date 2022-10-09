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
            QNode curr = q.poll();
            TreeNode n = curr.node;
            sum = curr.sum;
            
            if(n.left !=null) {
                q.offer(new QNode(n.left,n.left.val + sum));
            }
            
            if(n.right !=null) {
                q.offer(new QNode(n.right,n.right.val + sum));
            }
            
            if(n.left == null && n.right == null && sum == targetSum) {
                    return true;
            }
        }
        
        return false;
    }
}