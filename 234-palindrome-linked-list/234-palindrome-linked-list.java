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
    public boolean isPalindrome(ListNode head) {
        List<Integer> originalList = new ArrayList<>();
        List<Integer> reverseList = new ArrayList<>();
        while(head != null){
            originalList.add(head.val);
            head = head.next;
        }
        System.out.println(originalList); 
        reverseList = originalList.stream().collect(Collectors.toList());
        Collections.reverse(reverseList);
        System.out.println(reverseList);
        int n = originalList.size();
        for(int i=0;i<originalList.size();i++) {
            if(originalList.get(i) != reverseList.get(i)) {
                return false;
            }
        }
        return true;
    }
}