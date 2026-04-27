class Solution {
    public int maxProfit(int[] prices) {
       int maxProfit = 0;
       int i = 0, j = 0;
       while( j < prices.length ){
            if ( prices[j] - prices[i] <= 0 ){
                i = j;
            }
            else {
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            }
            j++;
       } 
       return maxProfit;
    }
}
