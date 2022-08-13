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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) 
            return list2;
        if(list2 == null)
            return list1;
        
        ListNode one = list1;
        ListNode two = list2;
        ListNode newHead = new ListNode(0);
        ListNode curr = newHead;
        
        while(one != null && two != null) {
            if(one.val <= two.val) {
                curr.next = one;
                one = one.next;
            } else {
                curr.next = two;
                two = two.next;
            }
            curr = curr.next;
        }
        
        if(one!=null) {
            curr.next = one;
        }
  
        
          if(two!=null) {
            curr.next = two;
        }
        
        return newHead.next;
        
        
    }
}