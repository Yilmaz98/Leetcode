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
    Map<Integer, List<Long>> m = new HashMap<>();
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        long maxWidth = 1;
        inorderUtil(root, 1, 1);
        System.out.println(m);
        for(Integer i: m.keySet()) {
            long currWidth = 1;
            currWidth = m.get(i).get(1) - m.get(i).get(0) + 1;
            maxWidth = Math.max(maxWidth, currWidth);
        }
        return (int) maxWidth;
    }
    
    public void inorderUtil(TreeNode root, long width, int level) {
        if(root != null) {
            if(!m.containsKey(level)) {
                m.put(level, new ArrayList<>());
                m.get(level).add(width);
                m.get(level).add(width);
            } else {
                 long min = Math.min(m.get(level).get(0),width);
                 long max = Math.max(m.get(level).get(1),width);
                 m.get(level).set(0, min);
                 m.get(level).set(1, max);
            }
           
            inorderUtil(root.left, 2* width -1, level+1);
            inorderUtil(root.right, 2* width,level+1);
        }  
    }
}