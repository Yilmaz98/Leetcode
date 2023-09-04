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
    public ListNode partition(ListNode head, int x) {
        ListNode temp = head;
        
        ListNode prev = new ListNode(0);
        prev.next = head;     
        ListNode start = prev;
        
        ListNode small = new ListNode(0);
        ListNode newHead = small;
        
        
        while(temp != null) {
            if(temp.val < x) {
                small.next = new ListNode(temp.val);
                small = small.next;
                prev.next = temp.next;
                temp = prev.next;
            }
            else {
                prev = temp;
                temp = temp.next;
            }
        }
        
        small.next = start.next;
         
        return newHead.next;
    }
}