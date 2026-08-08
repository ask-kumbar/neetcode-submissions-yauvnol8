class Solution {
    List<List<Integer>> output;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        output = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSets(candidates, target, 0, 0, new ArrayList<>());
        return output;
    }

    public void combinationSets(int[] candidates, int target, int sum, int i, List<Integer> set) {
        if(sum > target){
            return;
        }
        if(target == sum){
            output.add(new ArrayList<>(set));
        }
        for (int j = i; j < candidates.length; j++){
            if (j > i && candidates[j] == candidates[j - 1]) {
            continue; // skip duplicates at this recursion level only
        }
            set.add(candidates[j]);
            combinationSets(candidates, target, sum + candidates[j], j + 1, set);
            set.remove(set.size() - 1);

        }
    }
}
