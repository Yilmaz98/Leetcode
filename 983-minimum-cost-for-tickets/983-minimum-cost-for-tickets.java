class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int maxDays = 0;
        
        Set<Integer> visitedDays = new HashSet<>();
        for(int i=0;i<days.length;i++) {
            maxDays = Math.max(maxDays, days[i]);
            visitedDays.add(days[i]);
        }
        
        int maxCost = 0;
        Map<Integer, Integer> m = new HashMap<>();
        m.put(1,costs[0]);
        m.put(7,costs[1]);
        m.put(30, costs[2]);
        
        int minCost = Integer.MAX_VALUE;
        for(int i=0;i<costs.length;i++) {
            maxCost = Math.max(maxCost, costs[i]);
            minCost = Math.min(minCost, costs[i]);
        }
        
        int dp[] = new int[maxDays + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
         for(int i=1;i<dp.length;i++) {
             if(!visitedDays.contains(i)) {
                 dp[i] = dp[i-1];
                 continue;
             }
             
                if(i>=1) {
                    dp[i] = Math.min(dp[i], dp[i-1] + minCost);
                    if(i>=1 && i< 7)
                        dp[i] = Math.min(dp[i], m.get(7));
                }
                
                if(i>=7) {
                   dp[i] = Math.min(dp[i], dp[i-7] + m.get(7));
                    if(i%7 ==0) {
                        dp[i] = Math.min(dp[i], dp[0] + (i/7) * m.get(7));
                    }
                    if(i>=7 && i< 30)
                        dp[i] = Math.min(dp[i], m.get(30));
                }
             
                if(i>=30) {
                    dp[i] = Math.min(dp[i], dp[i-30] + m.get(30));
                      if(i%30 ==0) {
                        dp[i] = Math.min(dp[i], dp[0] + (i/30) * m.get(30));
                    }
                }
        }
        
        for(int i=0;i<dp.length;i++){
            System.out.print(dp[i] + " ");
        }
        
        return dp[maxDays];
    }
}