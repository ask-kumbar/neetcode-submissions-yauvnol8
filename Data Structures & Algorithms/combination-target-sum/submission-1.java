class Solution {
    List<List<Integer>> output;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        output = new ArrayList<>();
        combinationsEqualToSum(nums, target, 0, 0, new ArrayList<>());
        return output;
    }

    public void combinationsEqualToSum(int[] nums, int target, int sum, int i, List<Integer> set) {
        
        if (sum > target) {
            return;
        }
        if (sum == target) {
            output.add(new ArrayList<>(set));
        }

        for (int j = i; j < nums.length; j++) {
            set.add(nums[j]);
            combinationsEqualToSum(nums, target, sum + nums[j], j, set);
            set.remove(set.size() - 1);
        }
    }
}
