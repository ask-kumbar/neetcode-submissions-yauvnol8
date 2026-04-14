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
            ListNode pTemp = head;
            ListNode pNth = head;
            for (int i = 0; i < n; i++ ){
                pTemp = pTemp.next;
            }

            if (pTemp == null){
                return head.next;
            }

            while(pTemp.next != null){
                pTemp = pTemp.next;
                pNth = pNth.next;
            }

            ListNode temp = pNth.next;
            pNth.next = temp.next;
            temp.next = null;
            return head;
    }
}
