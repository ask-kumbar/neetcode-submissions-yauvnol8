class Solution {
    List<List<Integer>> output;
    public List<List<Integer>> permute(int[] nums) {
        output = new ArrayList<>();
        permutations(nums, new ArrayList<>());
        return output;
    }

    public void permutations(int[] nums, List<Integer> set) {
        if(set.size() == nums.length) {
            output.add(new ArrayList<>(set));
            return;
        }
        for (int num : nums) {
            if(!set.contains(num)){
                set.add(num);
                permutations(nums, set);
                set.remove(set.size() - 1);
            }
        }
    }
}
