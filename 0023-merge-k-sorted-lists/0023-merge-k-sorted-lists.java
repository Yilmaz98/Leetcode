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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        
        return traverse(lists, 0, lists.length-1);
    }
    
    private ListNode traverse(ListNode[] lists, int lo, int hi){
        if (lo == hi) return lists[lo];
        
        int mid = (lo + hi)/2;
        ListNode l1 = traverse(lists, lo, mid);
        ListNode l2 = traverse(lists, mid+1, hi);
        
        return merge(l1, l2);
    }
    
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode mainHead = head;
        while(l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        
        if (l1 != null) {
            head.next = l1;
        }
        
        if (l2 != null) {
            head.next = l2;
        }
        return mainHead.next;
    }
}