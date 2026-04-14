class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        PriorityQueue<int[]> p = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (int[] trip : trips) {
            p.offer(trip);
        }
        int remainingCapacity = capacity;
        int[] curr = null, next = null;
        while(!p.isEmpty()) {
            if (curr == null) {
                curr = p.poll();
                if (remainingCapacity < curr[0]){
                    return false;
                }
            }
            else {
                curr = next;
            }
            remainingCapacity -= curr[0];

            if(!p.isEmpty()){
                next = p.poll();
                if (next[1] < curr[2]) {
                    if (remainingCapacity < next[0]){
                        return false;}
                    remainingCapacity -= next[0];
                }
                else {
                    remainingCapacity = capacity;
                }

            }
        }
        return true;
    }

}
