class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<int[]> jobs = new ArrayList<>();
        
        for(int i =0;i<startTime.length;i++) {
            jobs.add(new int[]{startTime[i], endTime[i], profit[i]});
        }
        
        Collections.sort(jobs, (a,b) -> a[0] - b[0]);
        
        int[] dp = new int[startTime.length];
        Arrays.fill(dp, -1);
        
        return recurse(dp, jobs, 0);
    }
    
    public int recurse(int[] dp, List<int[]> jobs, int start) {
        if(start == jobs.size()) {
            return 0;
        }
        
        if(dp[start] != -1)
            return dp[start];
        
        int take = 0;
        int notTake = 0;
        
        int next = findNext(start, jobs);
        
        take = jobs.get(start)[2] + (next == -1? 0 : recurse(dp, jobs, next));
           
        notTake = recurse(dp, jobs, start + 1);
        
        return dp[start] = Math.max(take, notTake);
    }
    
     int findNext(int idx, List<int[]> jobs) {
        int lo = idx + 1;
        int hi = jobs.size() -1;
        while(lo <= hi) {
            int mid = lo + (hi - lo)/2;
            if(jobs.get(mid)[0] >= jobs.get(idx)[1]) {
                if(jobs.get(mid-1)[0] >= jobs.get(idx)[1])
                    hi = mid - 1;
                else 
                    return mid;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }
}