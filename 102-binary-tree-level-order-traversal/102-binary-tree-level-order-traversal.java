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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        
        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);
        
        while(!qu.isEmpty()) {
            List<Integer> tempList = new ArrayList<>();
            int size = qu.size();
            for(int i=0;i<size;i++) {
               TreeNode n = qu.poll();
               
               tempList.add(n.val);
        
               if(n.left != null) {
                   qu.offer(n.left);
               }
               
               if(n.right != null) {
                    qu.offer(n.right);
                }
            }
            result.add(new ArrayList<>(tempList));
        }
        
        return result;
    }
    
}