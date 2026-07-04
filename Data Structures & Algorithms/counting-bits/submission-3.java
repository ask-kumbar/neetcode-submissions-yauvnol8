class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        result[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            result[i] = result[(int)i/2] + i % 2;
        }
        return result;
    }
}
