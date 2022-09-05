/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        
        if(root == null)
            return result;
        
        Queue<Node> q  = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            
            for(int i=0;i<size;i++) {
                Node curr = q.poll();
                
                temp.add(curr.val);
                
                for(Node n : curr.children) {
                    if(n!=null)
                        q.add(n);
                }
            }
            
            result.add(temp);

        }
        
        return result;
    }
}