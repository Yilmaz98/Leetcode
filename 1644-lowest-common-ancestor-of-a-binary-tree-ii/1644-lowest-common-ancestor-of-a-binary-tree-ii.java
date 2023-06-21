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
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        
        while(!qu.isEmpty()) {
            TreeNode curr = qu.poll();
            
            if(curr.left != null) {
                parentMap.put(curr.left,curr);
                qu.add(curr.left);
            }
            
            if(curr.right != null) {
                 parentMap.put(curr.right,curr);
                 qu.add(curr.right);
            }
        }
        
        if(!parentMap.containsKey(p) || !parentMap.containsKey(q))
                return null;
        
        
        Set<TreeNode> ancestors = new HashSet<>();
        
        while(p != null) {
            ancestors.add(p);
            p = parentMap.get(p);
        }
        
        while(!ancestors.contains(q)) {
            q = parentMap.get(q);
        }
        
        return q;
    }
}