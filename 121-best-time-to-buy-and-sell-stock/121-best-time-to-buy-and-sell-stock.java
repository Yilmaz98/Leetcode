class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minElement = Integer.MAX_VALUE;
        
        for(int i=0;i<prices.length;i++) {
            minElement = Math.min(minElement, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minElement);
        }
        
        return maxProfit;
        
    }
}