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
    public int minDiffInBST(TreeNode root) {
        if(root == null)    {
            return 0;
        }
         Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);
        int minDistance = Integer.MAX_VALUE;
        List<Integer> l = new ArrayList<>();
        int diff = 0;
        while(!qu.isEmpty()) {
            TreeNode n = qu.poll();
            l.add(n.val);
            if(n.left != null) {
                qu.offer(n.left);
            } 
            if(n.right != null) {
                qu.offer(n.right);
            }
        }
        
        Collections.sort(l);
        for(int i=1;i<l.size();i++) {
            diff = (l.get(i) - l.get(i-1)) < 0 ? l.get(i-1) - l.get(i) : l.get(i) - l.get(i-1);
            minDistance = Math.min(minDistance, diff);
        }
        return minDistance;
        
     }
}