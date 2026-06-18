class Solution {
    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        return binarySearch(nums, target, l, r);
    }

    public boolean binarySearch(int[] nums, int target, int l , int r) {
        if (l <= r) {
            int mid = l + (r - l) / 2;
            if (target == nums[mid]) {
                return true;
            }
            else if (nums[mid] > nums[l]) {
                if (target < nums[mid] && target >= nums[l]) {
                    return binarySearch(nums, target, l, mid - 1);
                }
                else {
                    return binarySearch(nums, target, mid + 1, r);
                }
            }
            else if (nums[mid] < nums[l]){
                if (target >= nums[l] || target < nums[mid]) {
                    return binarySearch(nums, target, l, mid - 1);
                }
                else {
                    return binarySearch(nums, target, mid + 1, r);
                }
            }
            else{
                if (target == nums[mid]) {
                    return true;
                }
                
                else {
                    return binarySearch(nums, target, l, mid - 1) || binarySearch(nums, target, mid + 1, r);
                }
            }
        }
        return false;
    }
    
}
