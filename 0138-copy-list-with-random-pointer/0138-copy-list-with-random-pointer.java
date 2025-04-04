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
        Node temp = head;
        while(temp != null){
            Node copyNode = new Node(temp.val);
            Node nextNode = temp.next;
            temp.next = copyNode;
            copyNode.next = nextNode;
            // Jump By + 2
            temp = temp.next.next;
        }
        temp = head;
        while(temp != null){
            Node copyNode = temp.next;
            Node randomeNode = temp.random;
            // Random Nodes Next is Our Copy Node
            if(randomeNode != null)
                copyNode.random = randomeNode.next;
            // Jumpy By + 2;
            temp = temp.next.next;
        }
        temp = head;
        Node newHead = new Node(-1);

        Node newTemp = newHead;
        System.out.println("yes");
        while(temp != null){
            Node copyNode = temp.next;
            temp.next = temp.next.next;
            newTemp.next = copyNode;
            temp = temp.next;
            newTemp = newTemp.next;
        }
        return newHead.next;
    }
}