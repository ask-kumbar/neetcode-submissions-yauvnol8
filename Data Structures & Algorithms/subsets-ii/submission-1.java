class Solution {
    List<List<Integer>> output;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        output = new ArrayList<>();
        Arrays.sort(nums);
        subsets(nums, 0, new ArrayList<>());
        return output;
    }

    public void subsets(int[] nums, int i, List<Integer> set) {
        output.add(new ArrayList<>(set));
        for (int j = i; j < nums.length; j++) {
            if (j > i && nums[j] == nums[j-1]) {
                continue;
            }
            set.add(nums[j]);
            subsets(nums, j + 1, set);
            set.remove(set.size() - 1);
        }
    }
}
