class Solution {

    public class DisjointSet {
        int[] s;
        public DisjointSet(int n) {
            s = new int[n];
            for (int i = 0; i < n; i++) {
                s[i] = -1;
            }
        }

        public int find(int a) {
            if(s[a] < 0) {
                return a;
            }
            return s[a] = find(s[a]);
        }

        public boolean union(int a, int b) {
            int roota = find(a);
            int rootb = find(b);

            if (roota == rootb) {
                return false;
            }
            
            if (s[roota] < s[rootb]){
                s[roota] += s[rootb];
                s[rootb] = roota;

            }
            else {
                s[rootb] += s[roota];
                s[roota] = rootb;
            }
            return true;
        }


    }
    public int[] findRedundantConnection(int[][] edges) {

        DisjointSet dsu = new DisjointSet(edges.length + 1) ;
        for (int[] edge : edges) {
            if (!dsu.union(edge[0], edge[1])) {
                return edge;
            }
        }
        return new int[0];
    }
}
