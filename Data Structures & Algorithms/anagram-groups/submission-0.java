class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<ArrayList<Integer>, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for(String s : strs) {
            ArrayList<Integer> count = new ArrayList<>(26);
            for(int i = 0; i < 26; i++) count.add(0);
            for(char c : s.toCharArray()) {
                count.set(c - 'a', count.get(c - 'a') + 1);
            }
            List<String> group = map.getOrDefault(count, new ArrayList<>());
            group.add(s);
            map.put(count, group);
        }
        result.addAll(map.values());
        return result;
    }
}
