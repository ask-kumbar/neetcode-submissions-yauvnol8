class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int l = 0, r = 0;
        int sum = 0;
        while (r < nums.length) {
            if (sum + nums[r] > nums[r]) {
                sum += nums[r];
            }
            else {
                sum = nums[r];
                l = r;
            }
            r++;
            max = Math.max(sum, max);
        }
        return max;
    }
}
