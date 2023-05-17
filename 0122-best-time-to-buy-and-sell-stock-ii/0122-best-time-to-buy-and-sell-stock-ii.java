class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n];
        
        for(int i=1;i<prices.length;i++) {
            if(prices[i] > prices[i-1])
                dp[i] = prices[i] - prices[i-1];
        }
        
        int sum = 0;
        
        for(int i=0;i<dp.length;i++) {
            sum += dp[i];
        }
        
        return sum;
    }
}