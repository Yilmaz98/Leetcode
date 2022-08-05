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
    public int countNodes(TreeNode root) {
        if(root == null)
            return 0;
        int lt = 1;
        TreeNode l = root.left;
        
        while(l!=null) {
            l = l.left;
            lt++;
        }
        
         int rt = 1;
        TreeNode r = root.right;
        
        while(r!=null) {
            r = r.right;
            rt++;
        }
        
        if(lt == rt)
            return (int)Math.pow(2,lt) -1;
        
        return 1 + countNodes(root.right) + countNodes(root.left);
    }
}