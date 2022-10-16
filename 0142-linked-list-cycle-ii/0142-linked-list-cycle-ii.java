/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null)
            return null;
        
        ListNode slow = head;
        ListNode fast = head;
        
        int count = 0;
        
        while(slow.next != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            count++;
            
            if(slow == fast)
                break;
        }
        
        if(fast.next == null || fast.next.next == null ) return null;
        
        while (head != slow) {
            head = head.next;
            slow = slow.next;
        }
        return head;
    }
}