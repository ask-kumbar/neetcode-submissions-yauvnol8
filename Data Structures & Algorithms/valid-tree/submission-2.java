class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length > n - 1) {
            return false;
        }
        int[][] adj = new int[n][n];

        for (int[] edge : edges) {
            adj[edge[0]][edge[1]] = 1;
            adj[edge[1]][edge[0]] = 1;
        }

        int[] visited = new int[n];
        if (!dfs(0, adj, -1, visited)){
            return false;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] != 1) {
                return false;
            }
        }
        return true;

    }

    public boolean dfs(int s, int[][] adj, int parent, int[] visited) {
        if (visited[s] == 1) {
            return false;
        }

        visited[s] = 1;

        for (int i = 0; i < adj.length; i++) {
            if(adj[s][i] == 1) {
                if (i == parent) {
                    continue;
                }

                if (!dfs(i, adj, s, visited)) {
                    return false;
                }
                
            }
        }
        return true;
    
    }
}
