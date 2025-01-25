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
        ListNode temp = new ListNode(-1);
        ListNode head = temp;
        int carry = 0;
        while(l1 != null || l2 != null || carry == 1){
            int val1 = 0, val2 = 0;
            if(l1 != null){
                val1 = l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                val2 = l2.val;
                l2 = l2.next;
            }
            int sum = val1 + val2 + carry;
            ListNode newNode = new ListNode(sum%10);
            temp.next = newNode;

            carry = sum/10;
            temp = temp.next;
        }
        return head.next;
    }
}