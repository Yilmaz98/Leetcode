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
    int idx = 0;
    
        public TreeNode buildTreeUtil(int[] preorder, int l, int r, Map<Integer, Integer> m) {
        if(r < l)
            return null;
        
        TreeNode root = new TreeNode(preorder[idx++]);
        root.left = buildTreeUtil(preorder, l, m.get(root.val) - 1, m);
        root.right =  buildTreeUtil(preorder, m.get(root.val) + 1, r, m);
        
        return root;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> m = new HashMap<>();
        
        for(int i=0;i<inorder.length;i++) {
            m.put(inorder[i], i);
        }
        
        return buildTreeUtil(preorder, 0, preorder.length - 1, m);
    }
    

}