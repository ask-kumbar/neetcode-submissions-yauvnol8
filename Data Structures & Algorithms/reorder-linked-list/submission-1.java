

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
        // java.util.Stack<ListNode> nodeStack = new java.util.Stack<>();
        // ListNode temp = head;
        // long len = 0;
        // while(temp != null){
        //     nodeStack.push(temp);
        //     temp = temp.next;
        //     len++;
        // }
        // temp = head;
        // long iter = len/2;
        // ListNode temp1;
        // while(iter > 0){
    
        //     ListNode node = nodeStack.pop();
        //     temp1 = temp.next;
        //     node.next = temp1;
        //     temp.next = node;
        //     temp = temp1; 
        //     iter--;
        // }
        // if(len % 2 == 0){
        //     temp.next.next = null;
        // }
        // else {
        //     temp.next = null;
        // }

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = slow.next;
        slow.next = null;
        ListNode prev = null;
        while (second != null){
            ListNode tmp = second.next;
            second.next = prev;
            prev = second;
            second = tmp;
        }
        ListNode first = head;
        second = prev;

        while (second != null){
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;
            first.next = second;
            second.next = temp1;
            first = temp1;
            second = temp2;
        }


    }
}
