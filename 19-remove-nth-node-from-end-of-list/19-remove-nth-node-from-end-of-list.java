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
        
        ListNode prev = new ListNode(0);
        prev.next = head;
        ListNode newHead = prev;
        ListNode curr = head;
        ListNode tempCurr = head;
        
        int count = 0;
        
        while(tempCurr!=null) {
            tempCurr = tempCurr.next;
            count++;
        }
        
        System.out.println(count);
        
        int pos = 0;
        while(curr!=null){
             if(pos == count - n) {
                 prev.next = curr.next;
                 break;
             }
            curr = curr.next;
           
            prev = prev.next;
            pos++;
        }
        
        System.out.println(pos);
        
        return newHead.next;
    }
}