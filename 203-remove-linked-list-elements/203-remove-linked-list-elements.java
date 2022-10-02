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
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) {
            return null;
        }
        
        ListNode prev = new ListNode(0);
        ListNode temp = prev;
        prev.next = head;
        
        while(head !=null) {
            if(head.val == val) {
                    if(head.next == null) 
                        prev.next = null;
                    else 
                        prev.next = head.next;
            } else {
                 prev = prev.next; 
            }
            //System.out.println(head.val);
            head = head.next;
        }
        return temp.next;
    }
}