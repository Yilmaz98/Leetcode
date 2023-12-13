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
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        ListNode result = new ListNode(0);
        ListNode head = result;
        
        while(temp1 != null && temp2 != null) {
            if(temp1.val <= temp2.val) {
                head.next = temp1;
                temp1 = temp1.next;
            } else {
                head.next = temp2;
                temp2 = temp2.next;
            }
            head = head.next;
        }
        
        if(temp1 != null)
            head.next = temp1;
        
        if(temp2 != null)
            head.next = temp2;
        
        return result.next;
    }
    
    public ListNode merge(ListNode[] lists, int low, int high) {
        if(low > high)
            return null;
        
        if(low == high) {
            return lists[low];
        }
        
        int mid = low + (high - low) / 2;
        ListNode left = merge(lists, low, mid);
        ListNode right = merge(lists, mid + 1, high);
        
        return mergeTwoLists(left, right);
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        return merge(lists, 0, n - 1);
    }
}