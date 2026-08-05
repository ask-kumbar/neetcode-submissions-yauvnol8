class Solution {
    public int subsetXORSum(int[] nums) {
        return xorSum(nums, 0, 0);
    }

    public int xorSum(int[] nums, int i, int xorVal) {
        if (nums.length == i) {
            return xorVal;
        }
        int value = xorSum(nums, i+1, xorVal) + xorSum(nums, i+1, nums[i] ^ xorVal);
        return value;
    }
}