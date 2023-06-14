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
        
        parentMap.put(root, null);
        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);
        
        while(!parentMap.containsKey(p) || !parentMap.containsKey(q) ) {
            TreeNode n = qu.poll();
            
            if(n.left != null) {
               qu.offer(n.left);
                parentMap.put(n.left, n);
            }
                
            if(n.right != null) {
                qu.offer(n.right);
                 parentMap.put(n.right, n);
            }   
        }
        
        Set<TreeNode> ancestors = new HashSet<>();
        
        while(p !=null) {
            ancestors.add(p);
            p = parentMap.get(p);
        }
        
        while(!ancestors.contains(q)) {
            q = parentMap.get(q);
        }
        
        return q;
        
    }
}