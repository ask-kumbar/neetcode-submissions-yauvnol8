class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> weights = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            weights.offer(stone);
        }
        while (weights.size() > 1) {
            int a = weights.poll();
            int b = weights.poll();
            weights.offer(a - b);
        }
        return weights.poll();
    }
}
