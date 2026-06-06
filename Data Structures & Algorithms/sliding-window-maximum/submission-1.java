class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        int l = 0;
        for (int r = 0; r < nums.length; r++) {

            if (r >= k) {
                result[l] = queue.peek();
                if(queue.peek() == nums[l]) {
                    queue.poll();
                }
                l++;

            }
            while (!queue.isEmpty() && queue.peekLast() < nums[r]){
                queue.pollLast();
            }
            queue.offer(nums[r]);

        }
        result[l] = queue.peek();
        return result;
    }
}
