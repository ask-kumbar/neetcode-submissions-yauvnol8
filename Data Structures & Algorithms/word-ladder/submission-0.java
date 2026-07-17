class Solution {

    public class Node {
        String s;
        int dist;
        Node(String s, int n) {
            this.s = s;
            this.dist = n;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Node> q = new ArrayDeque<>();
            String alphabets = "abcdefghijklmnopqrstuvwxyz";
            Map<String, Integer> map = new HashMap<>();
            for (String s : wordList) {
                map.put(s, 0);
            }
            q.offer(new Node(beginWord, 0));
            map.put(beginWord, 0);
            int steps = 0;
            while(!q.isEmpty()) {
                Node node = q.poll();
                String word = node.s;
                int n = node.dist;
                if(word.compareTo(endWord) == 0){
                    return n+1;
                }
                if (map.get(word) == 1) {
                    continue;
                }
                map.put(word, 1);
                for (int i = 0; i < word.length(); i++) {
                    for (char c : alphabets.toCharArray()) {
                        StringBuilder sb = new StringBuilder(word);
                        sb.setCharAt(i, c);
                        String s = sb.toString();
                        if(map.containsKey(s)) {
                            q.offer(new Node(s, n + 1));
                        }
                    }
                }

            }
            return 0;
    }
}
