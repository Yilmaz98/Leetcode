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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        dfs(root, 0, res);
        return res;
    }
    
    private void dfs(TreeNode root, int level, List<List<Integer>> res){
        if (root == null) return;
        if (level >= res.size()){
            LinkedList<Integer> newNode = new LinkedList<>();
            newNode.add(root.val);
            res.add(newNode);
        } else {
            if (level % 2 == 0) {
                res.get(level).add(root.val);
            } else {
                res.get(level).add(0, root.val);
            }
        }
        dfs(root.left, level+1, res);
        dfs(root.right, level+1, res);
    } 
}