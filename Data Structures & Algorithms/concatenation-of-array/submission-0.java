class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] numsConcat = new int[2 * nums.length];
        for (int i = 0; i < numsConcat.length; i++){
            numsConcat[i] = nums[i % nums.length];
        }
        return numsConcat;
    }
}