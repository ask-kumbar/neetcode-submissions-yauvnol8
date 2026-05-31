class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean[][] connection = new boolean[numCourses][numCourses];
        int[] inDegree = new int[numCourses];
        List<Integer> order = new ArrayList<>();
        for (int[] prerequisite : prerequisites) {
            connection[prerequisite[1]][prerequisite[0]] = true;
            inDegree[prerequisite[0]] += 1;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0){
                q.offer(i);
            }
        }
        int process = 0;
        while(!q.isEmpty()) {
            int u = q.poll();
            process++;
            order.add(u);
            for (int v = 0; v < numCourses; v++) {
                if (connection[u][v]) {
                    inDegree[v]--;
                    if (inDegree[v] == 0) {
                        q.offer(v);
                    }
                }
            }
        }

        if(process == numCourses) {
            return order.stream()
               .mapToInt(Integer::intValue)
               .toArray();    
        }
        return new int[0];
        
    }
    
}
