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
    public class SpecialNode {
        TreeNode node;
        boolean isMax;
        int currentMax;
        
        SpecialNode(TreeNode node, boolean isMax, int currentMax) {
            this.node = node;
            this.isMax = isMax;
            this.currentMax = currentMax;
        }
    }
    
    public int goodNodes(TreeNode root) {
        int goodNodes = 0;
        Queue<SpecialNode> q = new LinkedList<>();
        q.add(new SpecialNode(root,true,root.val));
        
        while(!q.isEmpty()) {
            SpecialNode curr = q.poll();
            
            if(curr.isMax == true) {
                goodNodes++;
            }
            
            if(curr.node.left != null) {
                if(curr.node.left.val >= curr.currentMax) {      
                    q.add(new SpecialNode(curr.node.left,true,curr.node.left.val));  
                } else {
                    q.add(new SpecialNode(curr.node.left, false, curr.currentMax));
                }
            }
            
            if(curr.node.right != null) {
            if(curr.node.right.val >= curr.currentMax) {
                    q.add(new SpecialNode(curr.node.right,true,curr.node.right.val));  
                } else {
                    q.add(new SpecialNode(curr.node.right, false, curr.currentMax));
                }
            }
        }
        
        return goodNodes;
    }
}