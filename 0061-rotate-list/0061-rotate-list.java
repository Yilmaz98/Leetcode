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
    public ListNode rotateRight(ListNode head, int k) {
        int count = 0;
        
        ListNode temp = head;
        
        while(temp != null) {
            count++;
            temp = temp.next;
        }
        
        if(count == 0)
            return head;
        
        k = k % count;
        
        temp = head;
        
        int prevValue = -101;
        int currVal = temp.val;

        ListNode start = head;
        
        while(k> 0) {
            temp = start;
                while(temp != null) {
            if(prevValue != -101) {
                currVal = temp.val;
                temp.val = prevValue;
            } 
            prevValue = currVal;
            temp = temp.next;
        }
        start.val = prevValue;
            k--;
        }
    
        
        return start;
    }
}