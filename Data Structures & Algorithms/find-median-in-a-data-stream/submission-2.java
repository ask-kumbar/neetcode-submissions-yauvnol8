class MedianFinder {

    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        this.minHeap = new PriorityQueue<>();
        this.maxHeap = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
        if (minHeap.isEmpty() || num >=  minHeap.peek()) {
            minHeap.offer(num);
        } else {
            maxHeap.offer(num);
        }
        int sizeMinHeap = minHeap.size();
        int sizeMaxHeap = maxHeap.size();
        while(sizeMinHeap - sizeMaxHeap > 1) {
            maxHeap.offer(minHeap.poll());
            sizeMinHeap = minHeap.size();
            sizeMaxHeap = maxHeap.size();
        }
        while (sizeMaxHeap - sizeMinHeap >= 1) {
            minHeap.offer(maxHeap.poll());
            sizeMinHeap = minHeap.size();
            sizeMaxHeap = maxHeap.size();
        }
    }

    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        } else {
            return minHeap.peek();
        }
    }
}
