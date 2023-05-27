class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length];
        helper(days,costs,dp,0,0);
        
        for(int i=0;i<dp.length;i++) {
            System.out.print(dp[i] + " ");
        }
        return dp[0];
    }
    
    public int helper(int[] days, int[] costs, int[] dp, int i,int day) {
        if(i >= days.length)
            return 0;
        
        if(days[i] <= day) {
            return helper(days,costs,dp,i+1,day);
        } 
        
        if(dp[i] != 0) {
            return dp[i];
        }
            
        int day1Pass = helper(days,costs,dp,i+1,days[i]) + costs[0];
        int day7Pass = helper(days,costs,dp,i+1,days[i] + 6) + costs[1];
        int day30Pass = helper(days,costs,dp,i+1,days[i] + 29) + costs[2];
        
        
        int result = Math.min(Math.min(day1Pass, day7Pass),day30Pass); 
        return dp[i] = result;
    } 
}