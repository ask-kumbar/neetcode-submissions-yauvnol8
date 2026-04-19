/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node != null) {
            Queue<Node> queue = new LinkedList<>();
            HashMap<Node, Node> map = new HashMap<>();
            queue.add(node);
            Node head = new Node(node.val);
            map.put(node, head);
            while(!queue.isEmpty()){
                Node temp = queue.poll();
                List<Node> newNeighbors = new ArrayList<>();
                    
                for (Node n : temp.neighbors){
                
                    
                    if(!map.containsKey(n)){
                        queue.add(n);
                        Node t = new Node(n.val);
                        map.put(n, t);
                    }
                    newNeighbors.add(map.get(n));
                }
                map.get(temp).neighbors = newNeighbors;
            }
            return head;
        }
        return null;
     }
}