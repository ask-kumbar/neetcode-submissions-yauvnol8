class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int minVal = Integer.MAX_VALUE;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            minVal = Math.min(minVal, nums[mid]);
            if (nums[r] >= nums[mid]) {
                r = mid - 1;
            }
            else if (nums[r] < nums[mid]) {
                l = mid + 1;
            }

        }
        return minVal;
    }
}
