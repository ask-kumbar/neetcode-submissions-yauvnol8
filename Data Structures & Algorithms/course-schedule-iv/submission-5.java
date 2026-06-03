class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
      int[][] adjMatrix = new int[numCourses][numCourses];
      for (int[] prerequisite : prerequisites){
        adjMatrix[prerequisite[0]][prerequisite[1]] = 1;
      }  

      Map<Integer, HashSet<Integer>> cache = new HashMap<>();
      List<Boolean> result = new ArrayList<>();
      for (int[] query : queries) {
        HashSet<Integer> hash = isprerequisite(query[0], cache, numCourses, adjMatrix);
        if(hash.contains(query[1])){
            result.add(true);
        }
        else {
            result.add(false);
        }
      }
      return result;

    }

    public HashSet<Integer> isprerequisite(int prereq, Map<Integer, HashSet<Integer>> cache, int n, int[][] adj) {
        if (cache.containsKey(prereq)) {
            return cache.get(prereq);
        }

        HashSet<Integer> hash = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (adj[prereq][i] == 1) {
                hash.add(i);
                hash.addAll(isprerequisite(i, cache, n, adj));
            }
        }
        cache.put(prereq, hash);
        return hash;
    }
}