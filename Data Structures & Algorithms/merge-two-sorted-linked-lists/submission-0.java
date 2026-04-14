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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null;
        ListNode current = null;
        ListNode current1 = list1;
        ListNode current2 = list2;
        while(current1 != null && current2 != null){
            ListNode node = null;
            if(current1.val <= current2.val){
                node = current1;
                current1 = current1.next;

            }
            else{
                node = current2;
                current2 = current2.next;
            }

            node.next = null;

            if(head == null){
                head = node;
                current = head;
            }
            else{
                current.next = node;
                current = current.next;
            }
                
        }

        if(current1 != null){
            if(head != null){
                current.next = current1;
            }
            else{
                head = current1;
            }
        }

        if(current2 != null){
            
            if(head != null){
                current.next = current2;
            }
            else{
                head = current2;
            }
        }

        return head;

    }
}