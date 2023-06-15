/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Set<Node> ancestors = new HashSet<>();
        
        while(p != null) {
            ancestors.add(p);
            p = p.parent;
        }
        
        while(!ancestors.contains(q)) {
            q = q.parent;
        }
        
        
        
        return q;
    }
}