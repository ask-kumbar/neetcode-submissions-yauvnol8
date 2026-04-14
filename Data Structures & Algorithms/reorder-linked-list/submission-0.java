

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
    public void reorderList(ListNode head) {
        java.util.Stack<ListNode> nodeStack = new java.util.Stack<>();
        ListNode temp = head;
        long len = 0;
        while(temp != null){
            nodeStack.push(temp);
            temp = temp.next;
            len++;
        }
        temp = head;
        long iter = len/2;
        ListNode temp1;
        while(iter > 0){
    
            ListNode node = nodeStack.pop();
            temp1 = temp.next;
            node.next = temp1;
            temp.next = node;
            temp = temp1; 
            iter--;
        }
        if(len % 2 == 0){
            temp.next.next = null;
        }
        else {
            temp.next = null;
        }

    }
}
