class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
      int[] indegree = new int[n];
      Map<Integer, List<Integer>> adjList = new HashMap<>();

      for (int[] edge : edges) {
        int a = edge[0], b = edge[1];
        indegree[a]++;
        indegree[b]++;
        if(!adjList.containsKey(a)) {
            adjList.put(a, new ArrayList<>());
            
        }
        adjList.get(a).add(b);

        if(!adjList.containsKey(b)) {
            adjList.put(b, new ArrayList<>());
        }
        adjList.get(b).add(a);
      }
    

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 1){
                q.offer(i);
            }
        }
        int remainingNodes = n;

        while(remainingNodes > 2) {
            remainingNodes -= q.size();
            int k = q.size();
            for (int i = 0; i < k; i++){
                int temp = q.poll();
                indegree[temp]--;
                for (int node : adjList.get(temp)) {
                    indegree[node]--;
                    if (indegree[node] == 1) {
                        q.offer(node);
                    }
                }
            }
        }
        
        List<Integer> result = new ArrayList<>(q);
        if(result.isEmpty()){
            for(int i = 0; i < n; i++) {
                result.add(i);
            }
        }
        return result;
    }
}