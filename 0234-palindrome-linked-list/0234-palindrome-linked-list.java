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
    ListNode front;
    public boolean isPalindrome(ListNode head) {
        front = head;
        return helper(head);
    }
    
    public boolean helper(ListNode head) {
        if(head == null)
            return true;
        
        if(!helper(head.next))
            return false;
              
        if(head.val != front.val) {
             front = front.next;
            return false;
        }
            
        front = front.next;
        
        return true;
    }
}