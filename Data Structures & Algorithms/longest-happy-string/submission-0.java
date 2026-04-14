class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> p = new PriorityQueue<>((d, e) -> e[0] - d[0]);
        if ( a > 0) {
            p.offer(new int[]{a, 0});
        }
        if ( b > 0) {
            p.offer(new int[]{b, 1});
        }
        if (c > 0) {
            p.offer(new int[]{c, 2});
        }
        int[] curr = null;
        int[] next = null;
        int cnt = 0;
        StringBuilder result = new StringBuilder();
        while(!p.isEmpty()) {
            if (next == null) {
                curr = p.poll();
            }
            else {
                curr = next;
                next = null;
            }
            if(result.length() > 0 && result.charAt(result.length() - 1) == (char)('a' + curr[1])){
                cnt++;
                if (cnt == 3) {
                    if(p.isEmpty()){
                        return result.toString();
                    }
                    next = p.poll();
                    p.offer(curr);
                    continue;
                }
            }
            else {
                cnt = 1;
            }

            result.append((char)('a' + curr[1]));
            curr[0]--;
            if (curr[0] > 0) {
                p.offer(curr);
            }
        }
        return result.toString();


    }
}