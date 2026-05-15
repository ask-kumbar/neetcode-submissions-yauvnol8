class Solution {
    public int mySqrt(int x) {
        if (x <= 1){
            return x;
        }
        int l = 1;
        int r = x / 2;

        while(l <= r) {
            int mid = l + (r - l) / 2;
            long val = (long)mid * mid;
            if (val == x) {
                return mid;
            }
            else if (val > x) {
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }
        return r;
    }
}