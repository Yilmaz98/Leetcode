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
    public ListNode middleNode(ListNode head) {
        if(head == null) {
            return null;
        }
        int length = 0;
        int i=0;
        ListNode temp = head;
        while(temp != null) {
            length++;
            temp = temp.next;
        }
        while(i<((length/2))) {
            head = head.next;
            i++;
        }
        return head;
    }
}