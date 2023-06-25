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
public class Node {
    TreeNode node;
    int val;
    
    Node(TreeNode node, int val) {
        this.node = node;
        this.val = val;
    }
};

class Solution {
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(root,root.val));
        
        int sum = 0;
        
        while(!q.isEmpty()) {
            Node curr = q.poll();
            
            if(curr.node.left == null && curr.node.right == null) {
                  sum += curr.val;
            }
              
            
            if(curr.node.left != null) {
                q.add(new Node(curr.node.left, curr.val * 10 + curr.node.left.val));
            }
            
            if(curr.node.right != null) {
                  q.add(new Node(curr.node.right, curr.val * 10 + curr.node.right.val));
            }
        }
        
        return sum;
    }
}