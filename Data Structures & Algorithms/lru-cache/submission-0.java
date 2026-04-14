
class LRUCache {
    public class Node{
    int key;
    int value;
    Node prev;
    Node next;
    public Node(int key, int value){
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
    public Node(int key, int value, Node prev, Node next){
        this.key = key;
        this.value = value;
        this.prev = prev;
        this.next = next;
    }
    
    
}

    private Node left;
    private Node right;
    private int cap;
    private java.util.HashMap<Integer, Node> cache;
    public LRUCache(int capacity) {
        this.cap = capacity;
        this.cache = new HashMap<>();
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);
        this.left.next = this.right;
        this.right.prev = this.left; 
    }

    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void insert(Node node){
        node.prev = this.right.prev;
        node.next = this.right;
        node.prev.next = node;
        node.next.prev = node;
    }

    public int get(int key) {
        if (cache.containsKey(key)){
            Node node = cache.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }
        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        insert(newNode);
        if (cache.size() > cap) {
            Node lru = this.left.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }
}
