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
    public ListNode removeNthFromEnd(ListNode head, int n) {

            ListNode dummy = new ListNode(0, head);
            ListNode pTemp = head;
            ListNode pNth = dummy;
            for (int i = 0; i < n; i++ ){
                pTemp = pTemp.next;
            }

            while(pTemp != null){
                pTemp = pTemp.next;
                pNth = pNth.next;
            }

            ListNode temp = pNth.next;
            pNth.next = temp.next;
            temp.next = null;
            return dummy.next;
    }
}
