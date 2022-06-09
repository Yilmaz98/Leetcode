/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
          
        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }
        
        ListNode headCurr = head;
        
        int size = stack.size();
        while (stack.size() >  Math.ceil((double)size/2)) {
            ListNode next = stack.pop();
            ListNode nextNext = headCurr.next;
            next.next = null;
            headCurr.next = next;
            next.next = nextNext;
            headCurr = nextNext;
        }
        
        
        if (headCurr != null)
            headCurr.next = null;
    }
}