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
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;
        
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
        
    while(!q.isEmpty()) {
        int size = q.size();
        for(int i=0;i<size;i++) {
        TreeNode curr = q.poll();
        TreeNode left = null;
        TreeNode right = null;
            
        if(curr.left != null && curr.right != null)
        {
            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;
            q.add(curr.left);
            q.add(curr.right);
        }
            
        else if(curr.left != null)
        {
            TreeNode temp = curr.left;
            curr.left = null;
            curr.right = temp;
            q.add(curr.right);
        }
            else if(curr.right != null)
        {
            TreeNode temp = curr.right;
            curr.right = null;
            curr.left = temp;
            q.add(curr.left);
        }
    
        }
    }
                
        return root;
    }
}