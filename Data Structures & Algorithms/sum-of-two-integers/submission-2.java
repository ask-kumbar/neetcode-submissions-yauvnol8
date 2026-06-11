class Solution {
    public int getSum(int a, int b) {
        int result = 0;
        int carry = 0;
        for (int i = 0; i < 32; i++) {
            int aBit = (a >> i) & 1;
            int bBit = (b >> i) & 1;
            int rBit = aBit ^ bBit ^ carry;
            result = result | (rBit << i);
            carry = (int)(aBit + bBit + carry) / 2;
        }
        return result;
    }
}
