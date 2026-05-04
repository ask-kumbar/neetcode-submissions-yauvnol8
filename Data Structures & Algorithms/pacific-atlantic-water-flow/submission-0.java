class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();
        int[][] pacificReached = new int[heights.length][heights[0].length];
        int[][] atlanticReached = new int[heights.length][heights[0].length];
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (i == 0 || j == 0) {
                    pacificQueue.add(new int[]{i, j});
                    pacificReached[i][j] = 1;
                }
                if (i == (heights.length - 1) || j == (heights[0].length - 1)) {
                    atlanticQueue.add(new int[]{i, j});
                    atlanticReached[i][j] = 1;
                }
            }
        }

        bfs(pacificQueue, pacificReached, heights);
        bfs(atlanticQueue, atlanticReached, heights);
        
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (pacificReached[i][j] == 1 && atlanticReached[i][j] == 1) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    public void bfs(Queue<int[]> q, int[][] reached, int[][] heights) {
        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        while (!q.isEmpty()) {
            int[] vertex = q.poll();
                
            for (int[] dir : directions) {
                int nr = vertex[0] + dir[0];
                int nc = vertex[1] + dir[1];
                if (nr >= 0 && nr < reached.length && nc >= 0 && nc < reached[0].length && reached[nr][nc] != 1 && heights[nr][nc] >= heights[vertex[0]][vertex[1]]) {
                    reached[nr][nc] = 1;
                    q.add(new int[]{nr, nc});
                }
            }
        }
    }
}
