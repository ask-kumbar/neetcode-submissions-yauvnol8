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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
       ListNode temp = head, next = null;
       while(temp.next != null){
        next = temp.next;
        ListNode node = new ListNode(gcd(temp.val, next.val));
        temp.next = node;
        node.next = next;
        temp = next;
       } 
       return head;
    }

    public int gcd(int m, int n) {
        if (n == 0) {
            return m;
        }

        if (m < n) {
            return gcd(n, m);
        }

        return gcd(n, m%n);
    }
}