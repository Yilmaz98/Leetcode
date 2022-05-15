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
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int res = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            res = 0;
            for(int i=0;i<size; i++) {
            TreeNode n = q.poll();
                res += n.val;
            if(n.left != null) {
                q.add(n.left);
            }
            
            if(n.right != null) {
                q.add(n.right);
            } 
            }
          
        }
        
        return res;
    }
}