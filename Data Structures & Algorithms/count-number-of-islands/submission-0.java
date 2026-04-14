class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        return findNumIslands(grid, visited);


    }

    public int findNumIslands(char[][] grid, boolean[][] visited) {

        int count = 0;
        for (int k = 0; k < grid.length; k++) {
            for (int l = 0; l < grid[0].length; l++) {
                if (grid[k][l] == '1' && !visited[k][l]) {
                    count += 1;
                    markIsland(grid, visited, k, l);
                }
            }
        }
        return count;

    }

    public void markIsland(char[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] == '0') {
            return;
        }
        visited[i][j] = true;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] dir : directions) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            markIsland(grid, visited, newI, newJ);
        }
    }
    
}
