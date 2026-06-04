class Solution {
    boolean[] visited;
    public int countComponents(int n, int[][] edges) {
        int[][] adj = new int[n][n];
        visited = new boolean[n];
        for (int[] edge : edges) {
            adj[edge[0]][edge[1]] = 1;
            adj[edge[1]][edge[0]] = 1;
        
        }

        int components = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, n, adj);
                components++;
            }
        }
        return components;
    }

    public void dfs(int s, int n, int[][] adj) {
        visited[s] = true;
        for (int i = 0; i < n; i++) {
            if(adj[s][i] == 1 && !visited[i]) {
                dfs(i, n, adj);
            }
        }
    }
}
