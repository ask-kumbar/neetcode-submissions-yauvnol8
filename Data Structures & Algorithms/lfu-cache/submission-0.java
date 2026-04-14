class LFUCache {

    public class Node{
        int value;
        Node prev;
        Node next;
        public Node(int value){
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    public class DLL{
        Node left;
        Node right;
        java.util.HashMap<Integer, Node> map;
        public DLL(){
            this.left = new Node(0);
            this.right = new Node(0);
            this.left.next = this.right;
            this.right.prev = this.left;
            this.map = new HashMap<>();
        }

        public void pushRight(int value){
            Node node = new Node(value);
            node.prev = this.right.prev;
            node.next = this.right;
            node.prev.next = node;
            node.next.prev = node;
            this.map.put(value, node);
        }

        public int length(){
            return this.map.size();
        }

        public void pop(int val){
            if(this.map.containsKey(val)){
                Node node = this.map.get(val);
                node.prev.next = node.next;
                node.next.prev = node.prev;
                this.map.remove(val);
            }
        }

        public int popLeft(){
            int res = this.left.next.value;
            pop(res);
            return res;
        }
        
        public void update(int val){
            pop(val);
            pushRight(val);
        }
    }

    private java.util.HashMap<Integer, Integer> valueMap;
    private java.util.HashMap<Integer, Integer> countMap;
    private java.util.HashMap<Integer, DLL> nodeMap;
    private int lfuCount;
    private int cap;

    public LFUCache(int capacity) {
        this.cap = capacity;
        this.lfuCount = 0;
        this.valueMap = new HashMap<>();
        this.countMap = new HashMap<>();
        this.nodeMap = new HashMap<>(); 
    }

    public void manageCounter(int key){
        int count = countMap.get(key);
        countMap.put(key, count + 1);
        nodeMap.putIfAbsent(count, new DLL());
        nodeMap.get(count).pop(key);
        nodeMap.putIfAbsent(count + 1, new DLL());
        nodeMap.get(count + 1).pushRight(key);

        if (count == lfuCount && nodeMap.get(count).length() == 0){
            lfuCount++;
        }
    }
    
    public int get(int key) {
        if (!valueMap.containsKey(key)){
            return -1;
        }
        manageCounter(key);
        return valueMap.get(key);
    }
    
    public void put(int key, int value) {
        if (this.cap == 0){
            return;
        }

        if(!valueMap.containsKey(key) && valueMap.size() == this.cap){
            int toRemove = nodeMap.get(lfuCount).popLeft();
            valueMap.remove(toRemove);
            countMap.remove(toRemove);
        }
        valueMap.put(key, value);
        countMap.putIfAbsent(key, 0);
        manageCounter(key);
        lfuCount = Math.min(lfuCount, countMap.get(key));
    }
}

/**+`
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */