class Solution {
    List<List<Integer>> output;
    public List<List<Integer>> combine(int n, int k) {
        output = new ArrayList<>();
        combinations(n, k, 1, new ArrayList<>());
        return output;
    }

    public void combinations(int n, int k, int i, List<Integer> set) {
        if (set.size() == k) {
            output.add(new ArrayList<>(set));
            return;
        }

        for (int j = i; j <= n; j++) {
            set.add(j);
            combinations(n, k, j + 1, set);
            set.remove(set.size() - 1);
        }
    }


}