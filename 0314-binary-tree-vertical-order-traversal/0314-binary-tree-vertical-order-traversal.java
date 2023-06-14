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
    class Node {
        TreeNode node;
        int col;
        
        Node(TreeNode node, int col) {
            this.node = node;
            this.col = col;
        }
    };
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        
        if(root == null)
            return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        
        TreeMap<Integer, List<Integer>> tm = new TreeMap<>();
        
        
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(root, 0));
        
        while(!q.isEmpty()) {
            Node curr = q.poll();
            
            if(!tm.containsKey(curr.col)) {
                tm.put(curr.col, new ArrayList<>());
            } 
            
            tm.get(curr.col).add(curr.node.val);
            
            if(curr.node.left != null) {
                q.add(new Node(curr.node.left, curr.col - 1));
            }
            
            
            if(curr.node.right != null) {
                q.add(new Node(curr.node.right, curr.col + 1));
            }
        }
        return new ArrayList<>(tm.values());
        
    }
    
    
}