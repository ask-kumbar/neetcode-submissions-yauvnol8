class Solution {
    public int maxArea(int[] heights) {
        int i = 0, j = heights.length - 1, max = 0;
        while (i < j) {
            max = Math.max(max, (j - i) * Math.min(heights[i], heights[j]));
            if(heights[i] < heights[j]) {
                i++;
            }
            else {
                j--;
            }
        }
        return max;
    }
}
