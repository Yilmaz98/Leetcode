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
    public ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
    
    public ListNode getFirstHalf(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    public boolean isPalindrome(ListNode head) {
        ListNode curr = head;
        
        ListNode firstHalf = getFirstHalf(head);
        ListNode secondHalf = reverse(firstHalf.next);
        
        
        ListNode temp = secondHalf;
        ListNode dummy = head;
        while(dummy != null && secondHalf != null) {
            if(dummy.val != secondHalf.val) {
                return false;
            }
            dummy = dummy.next;
            secondHalf = secondHalf.next;
        }
        
        firstHalf.next = reverse(temp);
        
        return true;
    }
}