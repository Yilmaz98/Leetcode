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
    class Node {
        TreeNode node;
        int sum;
        
        Node(TreeNode node, int sum) {
            this.node = node;
            this.sum = sum;
        }
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null)
            return false;
        
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(root,0));
        
        while(!q.isEmpty()) {
            Node curr = q.poll();
            
            curr.sum += curr.node.val;
            
            if(curr.node.left == null && curr.node.right == null) {
                if(curr.sum == targetSum)
                    return true;
            }
                    
            if(curr.node.left != null) {
                q.add(new Node(curr.node.left, curr.sum));
            }
            
              if(curr.node.right != null) {
                q.add(new Node(curr.node.right, curr.sum));
            }
        }
        
        return false;
    }
}