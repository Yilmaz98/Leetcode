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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)
            return null;
        
        ListNode temp = head;
        int count = 0;
        
        while(temp!=null) {
            count++;
            temp = temp.next;
        }
        
        int newN = count - n;
                
        ListNode curr = head;
        ListNode newHead = curr;
        
        if(newN == 0) {
            if(count == 1)
                return null;
            else
                return curr.next;
        }
        
        while(newN-->1) {
            curr = curr.next;
        }
        
        
        if(curr.next!=null && curr.next.next != null) {
            curr.next = curr.next.next;
        } else if(curr.next!=null) {
            curr.next = null;
        } else {
            return null;
        }
        
        return newHead;
        
    }
}