class Solution {
    List<List<Integer>> output;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        output = new ArrayList<>();
        combinationsEqualToSum(nums, target, 0, new ArrayList<>());
        return output;
    }

    public void combinationsEqualToSum(int[] nums, int target, int i, List<Integer> set) {
        int sum = 0;
        for (int item : set) {
            sum = sum + item;
        }
        if (sum > target) {
            return;
        }
        if (sum == target) {
            output.add(new ArrayList<>(set));
        }

        for (int j = i; j < nums.length; j++) {
            set.add(nums[j]);
            combinationsEqualToSum(nums, target, j, set);
            set.remove(set.size() - 1);
        }
    }
}
