

class MyHashSet {
    public boolean[] hashMap;

    public MyHashSet() {
        hashMap = new boolean[1000];
        Arrays.fill(hashMap, false);
    }
    
    public void add(int key) {
        hashMap[key % 1000] = true;
    }
    
    public void remove(int key) {
        hashMap[key % 1000] = false;
    }
    
    public boolean contains(int key) {
        return hashMap[key % 1000];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */