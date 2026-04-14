class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] frequency = new int[26];
        for(char task : tasks) {
            frequency[(int)task - 65] ++;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < 26 ; i++) {
            if (frequency[i] != 0) {
                queue.offer(frequency[i]);
            }
        }
        int max = queue.poll();
        int time = (max - 1) * (n + 1) + 1;
        
        while(queue.peek() != null && queue.peek() == max){
            time++;
            queue.poll();
        }
        return Math.max(time, tasks.length);
    }
}
