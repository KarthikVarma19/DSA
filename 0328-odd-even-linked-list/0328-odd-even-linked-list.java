
class Solution {
    public ListNode oddEvenList(ListNode head) {

        ListNode evenHead = new ListNode(-1);
        ListNode evenPointer = evenHead;
        ListNode oddHead  = new ListNode(-1);
        ListNode oddPointer = oddHead;
        ListNode temp = head;
        boolean flag = false;
        while(temp != null){
            ListNode node = temp;
            temp = temp.next;
            node.next = null;
            if(flag == true){
                evenPointer.next = node;
                evenPointer = evenPointer.next;
                flag = !flag;

            }
            else{
                oddPointer.next = node;
                oddPointer = oddPointer.next;
                flag = !flag;
            }
        }
        oddHead = oddHead.next;
        evenHead = evenHead.next;
        oddPointer.next = evenHead;
        return oddHead;
    }
}