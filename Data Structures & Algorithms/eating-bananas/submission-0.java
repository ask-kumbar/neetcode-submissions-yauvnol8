class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int r = Arrays.stream(piles).max().getAsInt();
        int l = 1;
        int out = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int x = getHours(piles, mid);
            if (x <= h) {
                out = mid;
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }
        return out;

    }

    public int getHours(int[] piles, int x){
        int hours = 0;
        for (int pile : piles)
        {
            hours += (pile + x - 1) / x;
        }
        return hours;
    }
}
