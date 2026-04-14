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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int count = 0;
        ListNode dummy = new ListNode(0, head);
        head = dummy;
        ListNode leftPtr = head;
        ListNode prevLeft = null;
        while (count != left){
            prevLeft = leftPtr;
            leftPtr = leftPtr.next;
            count += 1;
        }
        ListNode current = leftPtr;
        ListNode prev = dummy;
        while (count != right + 1){
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
            count += 1;
        }
        prevLeft.next = prev;
        leftPtr.next = current;
        return head.next;
    }
}