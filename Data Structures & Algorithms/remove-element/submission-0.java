class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0, j = 0;
        while(j < nums.length){

            while (j < nums.length && nums[i] != val){
                i++;
                j++;
            }
            while(j < nums.length && nums[j]==val){
                j++;
            }
            if(i < j && j < nums.length) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j++;
            }


        }
        return i;
    }

}