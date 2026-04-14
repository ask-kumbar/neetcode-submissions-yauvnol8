class Solution {
    public String reorganizeString(String s) {
        // Count frequency of each character
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        // Find character with maximum frequency
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                maxHeap.offer(new int[]{freq[i], i});
            }
        }
        StringBuilder result = new StringBuilder();
        int[] next = null;
        int[] curr = null;
        while (!maxHeap.isEmpty()) {
            if (next == null) {
                curr = maxHeap.poll();
            }
            else {
                curr = next;
                next = null;
            }
            result.append((char)('a' + curr[1]));
            curr[0]--;
            if (curr[0] > 0) {
                if(maxHeap.isEmpty()) {
                    return "";
                }
                next = maxHeap.poll();
                maxHeap.offer(curr);
            }
        }
            return result.toString();
    }
}