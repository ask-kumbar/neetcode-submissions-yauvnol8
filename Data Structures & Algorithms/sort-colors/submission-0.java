class Solution {
    public void sortColors(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int i = 0;
        for (int color : new int[]{0, 1, 2}) {
            int count = map.getOrDefault(color, 0);
            for (int j = 0; j < count && i < nums.length; j++) {
                nums[i++] = color;
            }
        }
    }
}