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
    public class Node {
        TreeNode curr;
        int col;
        int row;
        
        Node(TreeNode curr, int col, int row) {
            this.curr = curr;
            this.col = col;
            this.row = row;
        }
    }
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        
        List<List<Integer>> result = new ArrayList<>();
        
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(root,0,0));
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[1] != b[1] ? a[1] - b[1] :a[0] != b[0] ? a[0]- b[0] : a[3] - b[3] );
        
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                Node n = q.poll();  
                
                pq.add(new int[]{n.row, n.col,n.curr.val,i});
                
                if(n.curr.left != null) {
                    q.add(new Node(n.curr.left,n.col-1,n.row+1));
                }
                
                if(n.curr.right != null) {
                    q.add(new Node(n.curr.right,n.col+1,n.row+1));
                }
            }
        }
        
         
        while(!pq.isEmpty()) {
            List<Integer> arr = new ArrayList<>();
            int[] cur = pq.poll();
            arr.add(cur[2]);
            
            while(!pq.isEmpty() && cur[1]==pq.peek()[1]) 
                arr.add(pq.poll()[2]);
            
            result.add(arr);
        }
        
        return result;
    }
}