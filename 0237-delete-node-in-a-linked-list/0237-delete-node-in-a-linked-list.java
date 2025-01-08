/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        if(node == null){
            return;
        }
        ListNode prev = null;
        ListNode temp = node;
        while(temp.next != null){
            prev = temp;
            temp.val = temp.next.val;
            temp = temp.next;
        }
        prev.next = null;
    }
}