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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        int k1 = k;
        while(k1 > 0 && temp != null){
            temp = temp.next;
            k1--;
        }
        if (k1 > 0){
            return head;
        }
        ListNode prev = reverseKGroup(temp, k);
        ListNode current = head;
        while (current != temp){
            ListNode temp1 = current.next;
            current.next = prev;
            prev = current;
            current = temp1;
        }
        return prev;

    }

}
