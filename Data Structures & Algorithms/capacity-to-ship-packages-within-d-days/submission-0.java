class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int minWeight = Integer.MIN_VALUE;
        int maxWeight = 0;
        for (int weight : weights) {
            maxWeight += weight;
            minWeight = Math.max(minWeight, weight);
        }

        while (minWeight <= maxWeight) {
            int mid = minWeight + (maxWeight - minWeight) / 2;
            int noDays = calculateTheDays(weights, mid);
            if (noDays <= days){
                maxWeight = mid - 1;
            }
            else {
                minWeight = mid + 1;
            }
        }
        return minWeight;

    }

    public int calculateTheDays(int[] weights, int capacity){
        int days = 1;
        int sum = 0;
        for (int weight : weights) {
            if (sum + weight > capacity) {
                days += 1;
                sum = weight;
            }
            else {
                sum += weight;
            }
        }
        return days;
    }
}