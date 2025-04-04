/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node dHead = new Node(-1);
        Node dummy = dHead;
        Node temp = head;
        // <original, newlist>
        HashMap<Node,Node> map = new HashMap<>();
        while(temp != null){
            dummy.next = new Node(temp.val);
            dummy = dummy.next;
            map.put(temp, dummy);
            temp = temp.next;
        }
        // Removing -1 since we created a dummy node -1 
        dummy = dHead.next;
        dHead.next = null;
        dHead = dummy;
        temp = head;
        while(temp != null){
            Node rand = temp.random;
            if(rand != null){
                dummy.random = map.get(rand);
            }
            dummy = dummy.next;
            temp = temp.next;
        }
        return dHead;
    }
}