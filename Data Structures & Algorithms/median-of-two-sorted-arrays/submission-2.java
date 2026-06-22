class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int half = (nums1.length + nums2.length) / 2;
        int[] m, n;
        if (nums1.length <= nums2.length) {
            m = nums1;
            n = nums2;
        }
        else {
            n = nums1;
            m = nums2;
        }
        if (m.length == 0) {
            return n.length % 2 == 0? (double) (n[half] + n[half - 1]) / 2 : n[half];
        }
        if (n.length == 0) {
            return m.length % 2 == 0? (double) (m[half] + m[half - 1]) / 2 : m[half];
        }
        int l = 0, r = m.length;
        while (l <= r) {
            int partitionA = l + (r - l) / 2;
            int partitionB = half - partitionA;
            int aleft = (partitionA == 0)? Integer.MIN_VALUE : m[partitionA - 1];

            int aright = (partitionA == m.length)? Integer.MAX_VALUE : m[partitionA];

            int bleft = (partitionB == 0)? Integer.MIN_VALUE : n[partitionB - 1];

            int bright = (partitionB == n.length)? Integer.MAX_VALUE : n[partitionB];

            if (aleft <= bright && bleft <= aright) {
                if (half % 2 == 0) {
                    return (double) (Math.max(aleft, bleft) + Math.min(aright, bright) )/ 2;
                }
                else {
                    return Math.min(aright, bright);
                }
            }
            else if (aleft > bright) {
                r = partitionA - 1;
            }
            else {
                l = partitionA + 1;
            }

        }
        return  0;
    }
}