class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        // int result = left;
        // for (long i = (long) left + 1; i <= right; i++) {
        //     result &= (int)i;
        //     if (result == 0){
        //         return 0;
        //     }
        // }
        // return result;
        int shift = 0;
        while (left != right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }
        return left << shift;
    }
}