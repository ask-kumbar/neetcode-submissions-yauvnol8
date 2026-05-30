class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[][] connection = new boolean[numCourses][numCourses];
        int[] inDegree = new int[numCourses];
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

        while(!q.isEmpty()) {
            int u = q.poll();
            for (int v = 0; v < numCourses; v++) {
                if (connection[u][v]) {
                    inDegree[v]--;
                    if (inDegree[v] == 0) {
                        q.offer(v);
                    }
                }
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] != 0){
                return false;
            }
        }


        return true;
    }
}
