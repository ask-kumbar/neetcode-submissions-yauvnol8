class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        return findMax(grid, visited);
    }

    public int findMax(int[][] grid, boolean[][] visited) {
        int count = 0;
        for (int k = 0; k < grid.length; k++) {
            for (int l = 0; l < grid[0].length; l++) {
                if (grid[k][l] == 1 && !visited[k][l]) {
                    
                    count = Math.max(markIsland(grid, visited, k, l), count);
                }
            }
        }
        return count;

    }

    public int markIsland(int[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] == 0) {
            return 0;
        }
        visited[i][j] = true;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int max = 1;
        for (int[] dir : directions) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            max +=  markIsland(grid, visited, newI, newJ);
        }
        return max;
    }
    
}
