class Solution {
    public void sortColors(int[] nums) {
        // HashMap<Integer, Integer> map = new HashMap<>();
        // for (int num : nums) {
        //     map.put(num, map.getOrDefault(num, 0) + 1);
        // }
        // int i = 0;
        // for (int color : new int[]{0, 1, 2}) {
        //     int count = map.getOrDefault(color, 0);
        //     for (int j = 0; j < count && i < nums.length; j++) {
        //         nums[i++] = color;
        //     }
        // }

        int l = 0, i = 0, r = nums.length - 1;
        while(i <= r){
            if(nums[i] == 0){
                swap(nums, l, i);
                l++;
            }
            else if(nums[i] == 2){
                swap(nums, i, r);
                r--;
                i--;
            }
            i++;
        }
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}  