class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int lastDay = days[days.length-1];
        int[] dp = new int[lastDay + 1];
        Set<Integer> travelDays = new HashSet<>();
        for(int day: days) {
            travelDays.add(day);
        }
        
        for(int i=1;i<dp.length;i++) {
                if(!travelDays.contains(i)) {
                    dp[i] = dp[i-1];
                    continue;
                }
                
                dp[i] = Math.min(dp[i-1] + costs[0], Math.min(dp[Math.max(i-30,0)] + costs[2], dp[Math.max(i-7,0)] + costs[1]));
        }
                
        return dp[lastDay];
    }
}