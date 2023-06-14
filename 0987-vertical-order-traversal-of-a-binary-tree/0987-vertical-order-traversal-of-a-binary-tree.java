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
        int col;
        int row;
        TreeNode node;
        
        Node(int col, int row, TreeNode node) {
            this.col = col;
            this.row = row;
            this.node = node;
        }
    }
    
    public class MyComparator implements Comparator<Node> {
        public int compare(Node n1, Node n2) {
            if(n1.row == n2.row)
                return n1.node.val - n2.node.val;
            
            return n1.row - n2.row;
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        PriorityQueue<Node> q = new PriorityQueue<>(new MyComparator());
        q.add(new Node(0,0, root));
        
        TreeMap<Integer, List<Integer>> tm = new TreeMap<>();
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i<size;i++) {
            
            Node curr = q.poll();
            if(!tm.containsKey(curr.col))
                tm.put(curr.col, new ArrayList<>());
            
            tm.get(curr.col).add(curr.node.val);
            
            if(curr.node.left != null) {
                q.add(new Node(curr.col -1, curr.row + 1, curr.node.left));
            }
            
            if(curr.node.right != null) {
                q.add(new Node(curr.col + 1, curr.row + 1,curr.node.right));
            }
            }
        }
        
        return new ArrayList<>(tm.values());
    }
}