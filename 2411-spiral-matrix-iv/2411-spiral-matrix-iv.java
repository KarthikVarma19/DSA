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
    
    ListNode temp;

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        temp = head;
        int ans[][] = new int[m][n];
        int rs = 0, re = m-1, cs = 0, ce = n-1;

        while(rs <= re && cs <= ce){
            //left to right
            for(int i = cs; i <= ce; i++){
                ans[rs][i] = getValue();
            }
            rs++;
            //top to bottom
            for(int j = rs; j <= re; j++){
                ans[j][ce] = getValue();
            }
            ce--;
            //right to left
            if(rs <= re){
                for(int i = ce; i >= cs; i--){
                    ans[re][i] = getValue();
                }
                re--;
            }
            //bottom to top
            if(cs <= ce){
                for(int j = re; j >= rs; j--){
                    ans[j][cs] = getValue();
                }
                cs++;
            }
        }

        return ans;
    }
    
    //returns the linked list value
    public int getValue(){
        int val = -1;
        if(temp != null) {
            val = temp.val;
            temp = temp.next;
        }
        return val;
    }
}