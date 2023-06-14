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
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0,0, root));
        
        TreeMap<Integer, List<Node>> tm = new TreeMap<>();
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i<size;i++) {
            
            Node curr = q.poll();
            if(!tm.containsKey(curr.col))
                tm.put(curr.col, new ArrayList<>());
            
            tm.get(curr.col).add(curr);
            
            if(curr.node.left != null) {
                q.add(new Node(curr.col -1, curr.row + 1, curr.node.left));
            }
            
            if(curr.node.right != null) {
                q.add(new Node(curr.col + 1, curr.row + 1,curr.node.right));
            }
            }
        }
        
        List<List<Node>> temp = new ArrayList<>(tm.values());
        
        List<List<Integer>> result = new ArrayList<>();
        
        for(int i=0;i<temp.size();i++) {
            Collections.sort(temp.get(i), new Comparator<>() {
                @Override
                public int compare(Node n1, Node n2) {
                    if(n1.row == n2.row)
                        return n1.node.val - n2.node.val;
                    else 
                        return n1.row - n2.row;
                }
            });
            List<Integer> finalRow = new ArrayList<>();
             for(int j=0;j<temp.get(i).size();j++) {
                finalRow.add(temp.get(i).get(j).node.val);
             }
            result.add(finalRow);
        }
        
        return result;
    }
}