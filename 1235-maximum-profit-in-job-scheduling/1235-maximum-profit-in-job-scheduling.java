class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] arr = new int[startTime.length][3];
        
        for(int i=0;i<startTime.length;i++) {
            arr[i] = new int[]{startTime[i],endTime[i], profit[i]};
        }
        
        Arrays.sort(arr, (a,b) -> a[1] - b[1]);
                
        int n = startTime.length;
        int[] dp = new int[n];
        dp[0] = arr[0][2];
        
        for(int i=1;i<arr.length;i++) {
            dp[i] += arr[i][2];
            
            int low = -1;
            int high = i-1;
            
            
            while(low < high) {
                int mid = (int) Math.ceil((double) (low+high)/2);
                if(arr[mid][1] <=arr[i][0]) {
                    low = mid;
                } else {
                    high = mid -1;
                }
            }
            
            if(low !=-1)
                dp[i] += dp[low];
            dp[i] = Math.max(dp[i], dp[i-1]);
        }
        
        for(int i=0;i<n;i++) {
            System.out.print(dp[i] + " ");
        }
        
        return dp[n-1];
    }
}