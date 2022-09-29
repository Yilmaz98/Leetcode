/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) {
            return null;
        }
        Queue<Node> qu = new LinkedList<>();
        
        qu.offer(root);
        
        while(!qu.isEmpty()) {
            int size = qu.size();
            int count = 0;
            for(int i=0; i<size; i++) {
               
               Node n = qu.poll();
                
               if(count < size -1 )  {
                    n.next = qu.peek();  
                }
                else  {
                    n.next = null;  
                }
                count++;
                
               if (n.left != null)
                    qu.add(n.left);
            
               if (n.right != null)
                    qu.add(n.right); 
            }
        }
        
        return root;
    }
}