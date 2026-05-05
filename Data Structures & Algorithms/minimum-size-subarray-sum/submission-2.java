class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        
        for (int j = 0; j < nums.length; j++){
            sum += nums[j];
        
            while(sum >= target){
                minLen = Math.min(j - i + 1, minLen);
                sum -= nums[i];
                i++;
            }
        }
        return minLen != Integer.MAX_VALUE ? minLen : 0;
    }
}