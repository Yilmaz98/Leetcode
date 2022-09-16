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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        
        Set<Integer> s = new HashSet<>();
        
        for(int i : to_delete) {
            s.add(i);
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        List<TreeNode> result = new ArrayList<>();
                
        result.add(root);
        
        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            
            if(s.contains(curr.val)) {
                result.remove(curr);
                if(curr.left != null) {
                     result.add(curr.left);
                }
            
                if(curr.right != null) {
                    result.add(curr.right);
                }
 
            }
            
            if(curr.left != null) {
                 q.add(curr.left);
                if(s.contains(curr.left.val)) {
                    curr.left = null;
                }
            }
            
            if(curr.right != null) {
                q.add(curr.right);
                 if(s.contains(curr.right.val)) {
                    curr.right = null;
                }
            }
        }

        
        return result;
    }
}