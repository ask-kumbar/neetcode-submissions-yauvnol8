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
            
            if (s[roota] <= s[rootb]){
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

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> emailMap = new HashMap<>();
        DisjointSet dsu = new DisjointSet(accounts.size());
        for (int i = 0; i < accounts.size(); i++) {
            for (int j= 1; j < accounts.get(i).size(); j++) {
                String emailId = accounts.get(i).get(j);
                if (emailMap.containsKey(emailId)) {
                    dsu.union(emailMap.get(emailId), i);
                }
                else {
                    emailMap.put(emailId, i);
                }
            }
        }

        Map<Integer, Set<String>> classesMap = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            int root = dsu.find(i);

            if (classesMap.containsKey(root)) {
                classesMap.get(root).addAll(
                    accounts.get(i).subList(1, accounts.get(i).size())
                );
            } else {
                classesMap.put(
                    root,
                    new HashSet<>(
                        accounts.get(i).subList(1, accounts.get(i).size())
                    )
                );
            }
        }

        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<Integer, Set<String>> entry : classesMap.entrySet()) {
            int root = entry.getKey();
            List<String> emailList = new ArrayList<>(entry.getValue());
            emailList.sort(null);
            List<String> merged = new ArrayList<>();
            merged.add(accounts.get(root).get(0));
            merged.addAll(emailList);
            result.add(merged);
        }
        return result;

    }
    
}