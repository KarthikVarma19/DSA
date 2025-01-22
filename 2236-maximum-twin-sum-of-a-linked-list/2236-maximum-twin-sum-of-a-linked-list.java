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
    public int pairSum(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;
        while((fast != null) && (fast.next.next != null)){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode nextList = slow.next;
        slow.next = null;
        ListNode secondList = reverseList(nextList);

        //Check for the max
        int maxSum = 0;
        for(ListNode temp1 = head, temp2 = secondList; temp1!=null && temp2!=null; ){
            if((temp1.val + temp2.val) > maxSum){
                maxSum = temp1.val + temp2.val;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return maxSum;
    }
    public ListNode reverseList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode prev = null;
        ListNode cur = head;
        ListNode nextNode = head;
        while(cur != null){
            nextNode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextNode;
        }
        return prev;
    }
}