class Solution {
    public class Node {
        int x, y, level;
        Node(int x, int y, int level) {
            this.x = x;
            this.y = y;
            this.level = level;

        }   
    }
    public int orangesRotting(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2)queue.add(new Node(i, j, 0));
            }
        }
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int minutes = 0;
        while(!queue.isEmpty()) {
            Node n = queue.poll();
            for (int[] dir : directions) {
                int r = n.x + dir[0];
                int c = n.y + dir[1];
                if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && !visited[r][c] && grid[r][c] == 1){
                    visited[r][c] = true;
                    grid[r][c] = 2;
                    queue.add(new Node(r, c, n.level + 1));
                }
            }
            if (queue.isEmpty()) {
                minutes = n.level;
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) return -1;
            }
        }
        return minutes;

    }
}
