/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> firstNodePath = new Stack<>();
        Set<TreeNode> secondNodePath = new HashSet<>();
        
        inorderFirst(root, p, firstNodePath);
        inorderSecond(root, q, secondNodePath);
        
        while(!firstNodePath.isEmpty()) {
            TreeNode curr = firstNodePath.pop();
            if(secondNodePath.contains(curr))
                return curr;
        }
        
        
        return root;
    }
    
    public boolean inorderFirst(TreeNode root, TreeNode p, Stack<TreeNode> firstNodePath) {
        if(root != null) {
            firstNodePath.add(root);
            
            if(!firstNodePath.isEmpty() && firstNodePath.peek() == p) {
                return true;
            }
            
            if(inorderFirst(root.left, p, firstNodePath))
                return true;
          
            
            if(inorderFirst(root.right, p, firstNodePath)) {
                    return true;
            }
            
            firstNodePath.pop();
        }
        return false;
    }
    
    public boolean inorderSecond(TreeNode root, TreeNode p, Set<TreeNode> secondNodePath) {
        if(root != null) {
            secondNodePath.add(root);
            
            if(secondNodePath.contains(p)) {
                return true;
            }
            
            if(inorderSecond(root.left, p, secondNodePath))
                return true;
          
            
            if(inorderSecond(root.right, p, secondNodePath)) {
                    return true;
            }
            
            secondNodePath.remove(root);
        }
        return false;
    }
}