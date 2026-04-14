/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
       java.util.HashMap<Node, Node> map = new HashMap<>();
       Node X = head, Y;
       while (X != null){
        Y = new Node(X.val);
        map.put(X, Y);
        X = X.next;
       }
       X = head;
       while(X != null){
        Y = map.get(X);
        Y.next = map.get(X.next);
        Y.random = map.get(X.random);
        X = X.next;
       }

       return map.get(head);
    }
}
