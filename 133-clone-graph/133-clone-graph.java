/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;
        
        Map<Node,Node> m = new HashMap<>();
        m.put(node, new Node(node.val));
        Node copy = m.get(node);
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        while(!q.isEmpty()) {
            Node n = q.poll();
            
            for(int i=0;i<n.neighbors.size();i++) {
                if(!m.containsKey(n.neighbors.get(i))) {
                    m.put(n.neighbors.get(i), new Node(n.neighbors.get(i).val));
                    q.offer(n.neighbors.get(i));
                }
                m.get(n).neighbors.add(m.get(n.neighbors.get(i)));
            }
        }
        
        System.out.println(m);
        return copy;
    }
}