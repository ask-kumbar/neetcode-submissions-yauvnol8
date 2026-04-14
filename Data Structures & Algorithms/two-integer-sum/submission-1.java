class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        map.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++)
        {
            int intermediate = target - nums[i];
            int intermediateIndex = map.getOrDefault(intermediate, -1);
            if (intermediateIndex != -1){
                if (i > intermediateIndex){
                    result[0] = intermediateIndex;
                    result[1] = i;
                }
                else{
                    result[1] = intermediateIndex;
                    result[0] = i;
                }
            }
            map.put(nums[i], i);
            
        }
        return result;
    }
}
