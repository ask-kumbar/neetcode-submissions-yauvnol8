class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] minimumCost = new int[cost.length + 1];

        for (int i = 2; i < cost.length + 1; i++){
            minimumCost[i] = Math.min(minimumCost[i - 1] + cost[i - 1], minimumCost[i - 2] + cost[i - 2]);
        }

        return minimumCost[minimumCost.length - 1];
    }
}
