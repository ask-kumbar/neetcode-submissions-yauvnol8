class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> orderMap = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            orderMap.put(order.charAt(i), i);
        }
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            int minLen = Math.min(word1.length(), word2.length());
            int j = 0;
            while (j < minLen) {
                if (orderMap.get(word1.charAt(j)) < orderMap.get(word2.charAt(j))) {
                    break;
                } else if (orderMap.get(word1.charAt(j)) > orderMap.get(word2.charAt(j))) {
                    return false;
                }
                j++;
            }
            if (j == minLen && word1.length() > word2.length()) {
                return false;
            }
        }
        return true;
    }
}