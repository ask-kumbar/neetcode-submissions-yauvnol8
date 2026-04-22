class Solution {
    public class Node {
        int x, y, dist;
        Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;

        }   
    }
    public void islandsAndTreasure(int[][] grid) {
       boolean[][] visited = new boolean[grid.length][grid[0].length];
       Queue<Node> queue = new LinkedList<>();
       for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    visited[i][j] = true;
                    queue.add(new Node(i, j, 0));
                }
            }
       }

       
       while (!queue.isEmpty()) {
            Node n = queue.poll();
            grid[n.x][n.y] = n.dist;
            addNode(grid, visited, queue, n.x + 1, n.y, n.dist + 1);
            addNode(grid, visited, queue, n.x - 1, n.y, n.dist + 1);
            addNode(grid, visited, queue, n.x, n.y + 1, n.dist + 1);
            addNode(grid, visited, queue, n.x, n.y - 1, n.dist + 1);
       }
    }

    public void addNode(int[][] grid, boolean[][] visited, Queue<Node> queue, int i, int j, int dist){
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == -1 || visited[i][j] == true){
            return;
        }
        visited[i][j] = true;
        queue.add(new Node(i, j, dist));
    }
}
