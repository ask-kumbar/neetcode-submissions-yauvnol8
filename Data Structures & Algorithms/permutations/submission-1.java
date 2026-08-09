class Solution {
    List<List<Integer>> output;
    public List<List<Integer>> permute(int[] nums) {
        output = new ArrayList<>();
        permutations(nums, new ArrayList<>(), new boolean[nums.length]);
        return output;
    }

    public void permutations(int[] nums, List<Integer> set, boolean[] picked) {
        if(set.size() == nums.length) {
            output.add(new ArrayList<>(set));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(!picked[i]){
                set.add(nums[i]);
                picked[i] = true;
                permutations(nums, set, picked);
                picked[i] = false;
                set.remove(set.size() - 1);
            }
        }
    }
}
