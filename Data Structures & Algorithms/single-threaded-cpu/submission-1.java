class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[] result = new int[n];
        PriorityQueue<int[]> p = new PriorityQueue<>((a, b) -> {
            int cmp = Integer.compare(a[0], b[0]);
            return cmp != 0 ? cmp : Integer.compare(a[2], b[2]);
        });
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
            int cmp = Integer.compare(a[1], b[1]);
            return cmp != 0 ? cmp : Integer.compare(a[2], b[2]);
        });
        for (int i = 0; i < n; i++) {
            p.offer(new int[]{tasks[i][0], tasks[i][1], i});
        }
        int time = 0;
        int resultIndex = 0;
        while (!p.isEmpty() || !q.isEmpty()) {
            if (q.isEmpty()) {
                int[] task = p.peek();
                if (time < task[0]){
                    time = task[0];}
                //time += task[1];
                //result[resultIndex++] = task[2];
            }
            while(!p.isEmpty() && p.peek()[0] <= time) {
                int[] task = p.poll();
                q.offer(task);
            }
            if (!q.isEmpty()) {
                int[] task = q.poll();
                result[resultIndex++] = task[2];
                time += task[1];
            }
        }
        return result;
    }
}