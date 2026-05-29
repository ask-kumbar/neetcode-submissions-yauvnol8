class Solution {
    public int openLock(String[] deadends, String target) {
        Queue<String> q = new ArrayDeque<>();
        Map<String, Integer> m = new HashMap<>();
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        m.put("0000", 0);
        q.offer("0000");
        if (dead.contains("0000")){
            return -1;
        }
        
        while(!q.isEmpty()) {
            String curr = q.poll();
            if (curr.equals(target)) {
                return m.get(curr);
            }
            for (int i = 0; i < 4; i++) {
                char[] arr = curr.toCharArray();
                arr[i] = (char) ((arr[i] - '0' + 1) % 10 + '0');

                String forward = new String(arr);

                arr = curr.toCharArray();

                arr[i] = (char) ((arr[i] - '0' + 9) % 10 + '0');

                String backward = new String(arr);

                if (!dead.contains(forward) && !m.containsKey(forward)) {
                    m.put(forward, m.get(curr) + 1);
                    q.offer(forward);
                }

                if (!dead.contains(backward) && !m.containsKey(backward)) {
                    m.put(backward, m.get(curr) + 1);
                    q.offer(backward);
                }


            }
        }

        return -1;
    }
}