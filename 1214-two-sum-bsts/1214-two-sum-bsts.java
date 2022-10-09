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
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root1);
        
        Set<Integer> s = new HashSet<>();
        
        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            
            s.add(curr.val);
            
            if(curr.left != null) {
                q.add(curr.left);
            }
            
            if(curr.right != null) {
                q.add(curr.right);
            }
        }
        
        q = new LinkedList<>();
        q.add(root2);
        
        
        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            
            if(s.contains(target - curr.val)) {
                return true;
            }
            
            if(curr.left != null) {
                q.add(curr.left);
            }
            
            if(curr.right != null) {
                q.add(curr.right);
            }
        }
        
        return false;
    }
}