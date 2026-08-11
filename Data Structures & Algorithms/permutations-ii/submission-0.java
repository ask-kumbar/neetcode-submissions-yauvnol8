class Solution {
    List<List<Integer>> output;

    public List<List<Integer>> permuteUnique(int[] nums) {
        output = new ArrayList<>();
        Arrays.sort(nums);
        permutations(nums, new ArrayList<>(), new boolean[nums.length]);
        return output;
    }

    public void permutations(int[] nums, List<Integer> set, boolean[] picked) {
        if (set.size() == nums.length) {
            output.add(new ArrayList<>(set));
            return;
        }

        for (int j = 0; j < nums.length; j++){
            if (j > 0 && nums[j] == nums[j-1] && !picked[j - 1]) {
                continue;
            }
            if(!picked[j]) {
                set.add(nums[j]);
                picked[j] = true;
                permutations(nums, set, picked);
                set.remove(set.size() - 1);
                picked[j] = false;
            }
        }
    }
}