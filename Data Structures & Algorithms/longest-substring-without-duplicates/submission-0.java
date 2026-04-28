class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int maxSize = 0;
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            while(set.contains(s.charAt(j))) {
                set.remove(s.charAt(i));
                i++;
            }
            set.add(s.charAt(j));
            maxSize = Math.max(set.size(), maxSize);
        }
        return maxSize;
    }
}
