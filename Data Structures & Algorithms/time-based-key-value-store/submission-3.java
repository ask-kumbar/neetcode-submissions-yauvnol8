class TimeMap {
    public class Pair {
        String value; 
        int timestamp;
        public Pair(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }
    Map<String, List<Pair>> timemap ; 
    public TimeMap() {
        timemap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!this.timemap.containsKey(key)) {
            this.timemap.put(key, new ArrayList<>());
        }
        this.timemap.get(key).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (this.timemap.containsKey(key)) {
            List<Pair> temp = this.timemap.get(key);
            int l = 0, r = temp.size() - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                int midTimestamp = temp.get(mid).timestamp;
                if (midTimestamp == timestamp){
                    return temp.get(mid).value;
                }
                else if (midTimestamp < timestamp) {
                    l = mid + 1;
                }
                else {
                    r = mid - 1;
                }
            }
            if (r >= 0) {
        return temp.get(r).value;
    }
        }
        return "";
    }
}
