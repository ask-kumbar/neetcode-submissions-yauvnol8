class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> minCap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for(int i = 0; i < capital.length; i++){
            minCap.add(new int[]{capital[i], profits[i]});
        }
        int currCap = w;
        PriorityQueue<Integer> maxProfit = new PriorityQueue<>((a, b) -> b - a);
        while(k>0){
            while(!minCap.isEmpty() && minCap.peek()[0] <= currCap){
                maxProfit.add(minCap.poll()[1]);
            }
            currCap += maxProfit.isEmpty() ? 0 : maxProfit.poll();
            k--;

        }
        return currCap;
    }
}