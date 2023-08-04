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
    public boolean firstAndLastEqual(List<Integer> valsArray) {
        for(int i=0;i<valsArray.size()/2;i++) {
            if(valsArray.get(i) != valsArray.get(valsArray.size()-i-1)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> valsArray = new ArrayList<>();
            for(int i=0;i<size;i++) {
                TreeNode curr = q.poll();
                if(curr == null) {
                     valsArray.add(-101);
                     continue;
                }
                                
                valsArray.add(curr.val);
                
                q.add(curr.left);
                q.add(curr.right);
            }  
            System.out.println(valsArray);
            if(!firstAndLastEqual(valsArray)) {
                return false;
            }
        }
        
        return true;
    }
}