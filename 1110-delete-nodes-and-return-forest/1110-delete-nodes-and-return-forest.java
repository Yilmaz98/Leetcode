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
        Set<Integer> deleteNodes = new HashSet<>();
        
        for(int i=0;i<to_delete.length;i++) {
            deleteNodes.add(to_delete[i]);
        }
                 
        List<TreeNode> result = new ArrayList<>();
                    
        inorder(root, deleteNodes, result);
        
        if(!deleteNodes.contains(root.val)) {
            result.add(root);
        }
        
        return result;
    }
    
    public TreeNode inorder(TreeNode root, Set<Integer> deleteNodes, List<TreeNode> result) {
        if(root == null)
            return null;
                
        root.left = inorder(root.left, deleteNodes, result);
        root.right = inorder(root.right, deleteNodes, result);
        
        if(deleteNodes.contains(root.val)) {
            if(root.left != null)
                result.add(root.left);
            if(root.right != null)
                result.add(root.right);
            root = null;
        }
        
        return root;
    }
}