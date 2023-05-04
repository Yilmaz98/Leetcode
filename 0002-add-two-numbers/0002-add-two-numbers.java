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
        ListNode l3 = new ListNode(0);
        ListNode head = l3;
        int sum = 0;
        int carry = 0;
        
        while(l1 !=null && l2!= null) {
            sum = l1.val+l2.val + carry;
            if(sum < 10) {
                carry = 0;
                l3.val = sum;
               // System.out.println(l3.val);
            } 
            else 
            {
                l3.val = sum%10;
                carry = 1;
            }
            l1 = l1.next;
            l2 = l2.next;
            if(l1 != null && l2 != null) {
                l3.next = new ListNode(0);
                l3 = l3.next;   
            }
        }
        
        if(l1 != null) {
            if(carry == 1) {
                l3.next = new ListNode(0);
                l3 = l3.next; 
                while(l1 != null) {
                    sum = l1.val + carry;
                     if(sum < 10) {
                    carry = 0;
                          l3.val = sum;
                } 
                else 
                 {
                l3.val = sum%10;
                carry = 1;
                }
                     l1 = l1.next;
            if(l1 != null) {
                l3.next = new ListNode(0);
                l3 = l3.next;   
            }
                }  
            } else {
                l3.next = l1;
            }
           
        }
        
        if(l2 != null) {
             if(carry == 1)  {
                             l3.next = new ListNode(0);
                l3 = l3.next;
                 while(l2 != null) {
                    sum = l2.val + carry;
                     if(sum < 10) {
                         l3.val = sum;
                    carry = 0;
                } 
                else 
                 {
                l3.val = sum%10;
                carry = 1;
                }
                     l2 = l2.next;
            if(l2 != null) {
                l3.next = new ListNode(0);
                l3 = l3.next;   
            }
                }
        }else {
                l3.next = l2;
            }
        }
        
        if(carry == 1)  {
            l3.next = new ListNode(1);
        }
            
        
        return head;
    }
}