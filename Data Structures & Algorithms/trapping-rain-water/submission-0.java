class Solution {
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int max = height[0];
        for (int i = 0; i < height.length; i++){
            leftMax[i] = Math.max(max, height[i]);
            max = leftMax[i];
        }

        max = height[height.length - 1];
        for (int i = height.length - 1; i >= 0; i--){
            rightMax[i] = Math.max(max, height[i]);
            max = rightMax[i];
        }
        int sum = 0;
        for (int i = 1; i < height.length -1 ; i++) {
            sum += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return sum;
    }
}
