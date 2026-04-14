class Solution {
    public int majorityElement(int[] nums) {
        int majorityValue = nums[0]; 
        int count = 1;
        for (int i = 1; i < nums.length; i++){
            if(count == 0){
                majorityValue = nums[i];
            }
            if (nums[i] != majorityValue){
                count--;
            }
            else{
                count++;
            }
        }
        return majorityValue;
    }
}
