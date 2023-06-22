/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        if(head == null) {
            Node add = new Node(insertVal);
            add.next = add;
            return add;
        }
           
        
        
        Node curr = head;
        Node next = curr.next;
        
        while(next != head) {
            if(curr.val <= insertVal && next.val >= insertVal) {
                 Node add = new Node(insertVal);
                 curr.next = add;
                 add.next = next;
                 return head;
            } else if(curr.val > next.val) {
                if(insertVal >= curr.val || insertVal <= next.val) {
                    Node add = new Node(insertVal);
                 curr.next = add;
                 add.next = next;
                 return head;
                }
            }
            
            System.out.println(curr.val + ":" + next.val);
            curr = next;
            next = curr.next;
        }
        
        Node add = new Node(insertVal);
        curr.next = add;
        add.next = next;
        return head;
        
    }
}