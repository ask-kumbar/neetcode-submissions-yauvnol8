class Solution {
    public void solve(char[][] board) {
        // using bfs from the edges
        int ROWS = board.length;
        int COL = board[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] reached = new boolean[ROWS][COL]; 
        
        for (int i = 0; i < COL; i++){
            if (board[0][i] == 'O') {
                q.add(new int[]{0, i});
                reached[0][i] = true;
            }
            if (board[ROWS - 1][i] == 'O'){
                q.add(new int[]{ROWS - 1, i});
                reached[ROWS - 1][i] = true;
            }
            
            
        }
        for (int i = 1; i < ROWS - 1; i++){
            
            if (board[i][0]== 'O'){
                q.add(new int[]{i, 0});
                reached[i][0] = true;
            }
            if (board[i][COL - 1] == 'O'){
                q.add(new int[]{i, COL - 1});
                reached[i][COL - 1] = true;
            }
            
        }
        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        boolean[][] reachable = new boolean[ROWS][COL];
        while(!q.isEmpty()){
            int[] vertex = q.poll();
            for (int[] dir : directions) {
                int nr = vertex[0] + dir[0];
                int nc = vertex[1] + dir[1];
                if (nr >= 0 && nr < reached.length && nc >= 0 && nc < reached[0].length && reached[nr][nc] != true) {
                    reached[nr][nc] = true;
                    if (board[nr][nc] == 'O') {
                        reachable[nr][nc] = true;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
        }

        for (int i = 1; i < ROWS - 1; i++){
            for (int j = 1; j < COL - 1; j++) {
                if (board[i][j] == 'O' && reachable[i][j] == false) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
