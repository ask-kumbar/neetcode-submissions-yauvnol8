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
    public ListNode reverseList(ListNode head) {
        
        if (  head == null || head.next == null){
            return head;
        }

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
        // if (head == null){
        //     return null;
        // }
        // else if (head.next == null){
        //     return head;
        // }
        // else {
        //     ListNode prev = head;
        //     ListNode current = head.next;
        //     prev.next = null;
        //     while (current != null){
        //         ListNode front = current.next;
        //         current.next = prev;
        //         prev = current;
        //         current = front;
        //     }
        //     head = prev;
        // }
        // return head;
    }
}
