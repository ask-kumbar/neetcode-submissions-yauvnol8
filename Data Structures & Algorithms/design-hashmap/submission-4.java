class MyHashMap {
    public int[] hashMap;

    public MyHashMap() {
        hashMap = new int[1000];
        for(int i = 0; i < hashMap.length; i++){
            hashMap[i] = -1;
        }
        
    }
    
    public void put(int key, int value) {
        hashMap[key % 1000] = value;
    }
    
    public int get(int key) {
        int val = this.hashMap[key % 1000];
        remove(key);
        return val;
        
    }
    
    public void remove(int key) {
        hashMap[key % 1000] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */