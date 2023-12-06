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
        Node runner1 = p;
        Node runner2 = q;
        
        while(runner1 != runner2) {
            if(runner1 != null) {
                runner1 = runner1.parent;
            } else {
                runner1 = q;
            }
            
            if(runner2 != null) {
                runner2 = runner2.parent;
            } else {
                runner2 = p;
            }
        }
        
        return runner1;
    }
}