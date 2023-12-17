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
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        boolean zig = true;
        List<List<Integer>> result = new ArrayList<>();
        
        if(root == null)
            return result;
        
        while(!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> tempList = new LinkedList<>();
            for(int i=0;i<size;i++) {
                TreeNode curr = q.poll();
                
                if(zig) {
                    tempList.addLast(curr.val);
                } else {
                    tempList.addFirst(curr.val);
                }
                
                if(curr.left != null) {
                    q.add(curr.left);
                }
                
                if(curr.right != null) {
                    q.add(curr.right);
                }
            }
            result.add(new ArrayList<>(tempList));
            zig = !zig;
        }
        
        return result;
    }
}