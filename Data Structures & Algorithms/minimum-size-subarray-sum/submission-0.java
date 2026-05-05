class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        int flag = 0;
        for (int j = 0; j < nums.length; j++){
            if (sum < target) {
                sum += nums[j];
            }
            while(sum >= target){
                flag = 1;
                minLen = Math.min(j - i + 1, minLen);
                sum -= nums[i];
                i++;
            }
        }
        return flag == 1 ? minLen : 0;
    }
}