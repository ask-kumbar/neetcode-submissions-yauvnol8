class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int j = Math.min(k, nums.length - 1);

        for (int a = 0; a <= j; a++) {
            if(map.containsKey(nums[a])) {
                return true;
            }
            map.put(nums[a], a);
        }
        while(j+1 < nums.length) {
            map.remove(nums[i]);
            i++;
            j++;
            if(map.containsKey(nums[j])) {
                return true;
            }
            map.put(nums[j], j);
        }
        return false;
    }
}