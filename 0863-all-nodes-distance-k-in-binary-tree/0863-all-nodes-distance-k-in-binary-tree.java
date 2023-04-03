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
    Map<Integer, String> m = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        inorder(root, ""); 
        List<Integer> result = new ArrayList<>();
        String targetString = m.get(target.val); 
        m.remove(target.val);
        
        for(Integer i : m.keySet()) {
            String val = m.get(i);
            
            int diff = Math.abs(val.length() - targetString.length());
            
            for(int j=0;j<Math.min(val.length(), targetString.length());j++) {
                if(val.charAt(j) != targetString.charAt(j)) {
                    diff += ((Math.min(val.length(), targetString.length()) -j) * 2);
                    break;
                } 
            }
            
            if(diff == k)
                result.add(i);
        }
        
        if(k==0)
            result.add(target.val);
        
        return result;
    }
    
    void inorder(TreeNode root, String curr) {
        if(root != null) {
            inorder(root.left, curr + "L");
            m.put(root.val, curr);
            inorder(root.right, curr+ "R"); 
        }
    }
}