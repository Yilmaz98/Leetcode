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
    
    public int dfsl(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        return 1 + dfsl(root.left);
    }
    
     public int dfsr(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        return 1 + dfsr(root.right);
    }
    
    public int countNodes(TreeNode root) {
        if(root == null)
            return 0;
        
        int lt = 1 + dfsl(root.left);
        int rt = 1 + dfsr(root.right);
        
        System.out.println(lt);
        System.out.println(rt);
        
        if(lt == rt)
            return (int)Math.pow(2,lt) -1;
        
        return 1 + countNodes(root.right) + countNodes(root.left);
    }
}