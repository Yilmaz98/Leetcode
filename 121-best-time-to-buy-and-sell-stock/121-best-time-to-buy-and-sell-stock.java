class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minElement = prices[0];
        
        for(int i=1;i<prices.length;i++) {
            minElement = Math.min(minElement, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minElement);
        }
        
        return maxProfit;
    }
}