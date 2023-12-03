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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        while(root != null) {
            List<Integer> tempList = new ArrayList<>();
            root = dfs(root, tempList);
            result.add(tempList);
        }
        return result;
    }
    
    public TreeNode dfs(TreeNode root, List<Integer> tempList) {
        if(root == null)
            return null;
        
                
        if(root.left == null && root.right == null) {
            tempList.add(root.val);
            return null;
        }
        
        root.left = dfs(root.left, tempList);
        root.right = dfs(root.right, tempList);
        
        return root;
    }
}