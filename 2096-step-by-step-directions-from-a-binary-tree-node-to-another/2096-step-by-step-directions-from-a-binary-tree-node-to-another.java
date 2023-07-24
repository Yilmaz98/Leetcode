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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode ancestor = lowestCommonAncestor(root, startValue, destValue);
        
        List<Character> toStart = new ArrayList<>();
        getDirections(ancestor,startValue,toStart);
        
        List<Character> toDest = new ArrayList<>();
        getDirections(ancestor,destValue,toDest);
        
        StringBuilder result = new StringBuilder();
        for(int i=0;i<toStart.size();i++) 
            result.append('U');
        
        for(char c : toDest)
            result.append(c);
        
        return result.toString();
    }
    
    public boolean getDirections(TreeNode root, int target, List<Character> dirs) {
        if(root == null)
            return false;
        
        dirs.add('L');
        if(getDirections(root.left, target, dirs))
            return true;
        dirs.remove(dirs.size() -1);
        
        dirs.add('R');
        if(getDirections(root.right, target, dirs))
            return true;
        dirs.remove(dirs.size() -1);
        
        return root.val == target;
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        if(root == null || root.val == p || root.val == q)
            return root;
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if(left != null && right != null)
            return root;
        else if(left == null)
            return right;
        else
            return left;
    }
}