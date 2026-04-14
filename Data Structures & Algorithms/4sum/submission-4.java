class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int i, j, k, l;
        List<List<Integer>> result = new ArrayList<>();
        for (i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
            
                k = j + 1;
                l = nums.length - 1;
                while (k < l) {
                    long sum = (long) nums[i] + nums[l] + nums[j] + nums[k];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));

                        while (k < l && nums[k] == nums[k + 1]) k++;

                        while (k < l && nums[l] == nums[l - 1]) l--;

                        k++;
                        l--;

                    } else if (sum > target) {
                        l--;

                    } else {
                        k++;
                    }

                }
            }
        }
        return result;
    }
}