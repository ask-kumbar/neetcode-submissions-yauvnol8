class Solution {
    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    public int binarySearch(int[] nums, int target, int l, int r) {
        if (l <= r) {
            int mid = l + (r - l) / 2;
            if (target < nums[l]) return l;
            if (target > nums[r]) return r + 1;
            if (target == nums[mid]) {
                return mid;
            }
            else if ( target < nums[mid])
            {   
                return binarySearch(nums, target, l, mid - 1);
            }
            else {
                return binarySearch(nums, target, mid + 1, r);
            }
        }
        return -1;
    }
    
}