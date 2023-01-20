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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        
        ListNode result = new ListNode(0);
        ListNode start = result;
        
        int carry = 0;
        
        while(temp1 != null && temp2 != null) {
            int sum = temp1.val + temp2.val;
            
            if(carry > 0) {
                sum += 1;
                carry = 0;
            }
            
            if(sum > 9) {
                sum = sum % 10;
                carry = 1;
            }
            
            result.next = new ListNode(sum);
            result = result.next;
            
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        
        while(temp1 != null) {
            int sum = temp1.val;
            if(carry > 0) {
                sum += 1;
                carry = 0;
            }
            
            if(sum > 9) {
                sum = sum % 10;
                carry = 1;
            }
            
            result.next = new ListNode(sum);
            result = result.next;
            
            temp1 = temp1.next;
        }
        
        while(temp2 != null) {
            int sum = temp2.val;
            if(carry > 0) {
                sum += 1;
                carry = 0;
            }
            
            if(sum > 9) {
                sum = sum % 10;
                carry = 1;
            }
            
            result.next = new ListNode(sum);
            result = result.next;
            
            temp2 = temp2.next;
        }
        
        if(carry > 0) {
            result.next = new ListNode(carry);
            result = result.next;
        }
        
        return start.next;
    }
}