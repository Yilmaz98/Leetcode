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
    List<Integer> tempList;
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        while(root != null) {
          tempList = new ArrayList<>();
          root = leafUtil(root);
          result.add(tempList);
        }
        
        return result;
    }
    
    public TreeNode leafUtil(TreeNode root) {
        if(root == null) {
            return null;
        }
        
        if(root.left == null && root.right == null) {
            tempList.add(root.val);
            return null;
        }
        
        root.left = leafUtil(root.left);
        root.right = leafUtil(root.right);
        
        return root;
    }
}