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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int x1 = 0;
        int x2 = 0;
        int multiplier = 1;
        
        while (l1 != null){
            x1 = x1 + l1.val * multiplier;
            multiplier = multiplier * 10;
            l1 = l1.next;
        }

        multiplier = 1;

        while (l2 != null){
            x2 = x2 + l2.val * multiplier;
            multiplier = multiplier * 10;
            l2 = l2.next;
        }

        int x3 = x1 + x2;
        ListNode head = new ListNode(0, null);
        ListNode temp = head;
        do {
            temp.next = new ListNode(x3 % 10, null);
            x3 = x3 / 10;
            temp = temp.next;
        } while (x3 != 0);

        return head.next;
    }
}
