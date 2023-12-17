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
    class SpecialNode {
        TreeNode node;
        int level;
        int row;
        
        SpecialNode(TreeNode node, int level, int row) {
            this.node = node;
            this.level = level;
            this.row = row;
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        if(root == null)
            return result;
        
        Queue<SpecialNode> q = new LinkedList<>();
        q.add(new SpecialNode(root, 0, 0));
        
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> tm = new TreeMap<>();
        
        while(!q.isEmpty()) {
            SpecialNode curr = q.poll();
            
            if(!tm.containsKey(curr.level)) {
                tm.put(curr.level, new TreeMap<>());
            } 
            
            if(!tm.get(curr.level).containsKey(curr.row))
                tm.get(curr.level).put(curr.row, new PriorityQueue<>());
            
            tm.get(curr.level).get(curr.row).add(curr.node.val);
            
            if(curr.node.left != null) {
                q.add(new SpecialNode(curr.node.left, curr.level - 1, curr.row + 1));
            }
            
            if(curr.node.right != null) {
               q.add(new SpecialNode(curr.node.right, curr.level + 1, curr.row + 1));
            }
        }

        for(TreeMap<Integer, PriorityQueue<Integer>> rows : tm.values()) {
            result.add(new ArrayList<>());
            for(PriorityQueue<Integer> pq : rows.values()) {
                while(!pq.isEmpty()) {
                    result.get(result.size() - 1).add(pq.poll());
                }
            }
        }
        
        return result;
    }
}